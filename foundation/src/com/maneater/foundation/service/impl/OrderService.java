package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.OrderInfo;
import com.maneater.foundation.nosql.entity.OrderItem;
import com.maneater.foundation.nosql.entity.Product;
import com.maneater.foundation.nosql.repository.OrderRepository;
import com.maneater.foundation.vo.AddInfo;
import com.maneater.foundation.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liang on 15/12/14.
 */
@Service
public class OrderService {

    private final static Object lock = new Object();
    @Resource
    private UserService userService = null;

    @Resource
    private OrderRepository orderRepository = null;

    @Resource
    private ProductService productService = null;


    public void addProduct(String userId, String productCode, int qty) {
        synchronized (lock) {
            Product product = productService.findByCode(productCode);
            Double price = product.getPriceByCode(productCode);

            OrderInfo orderInfo = getNoCommitOrder(userId);
            if (orderInfo == null) {
                orderInfo = new OrderInfo();
            }

            List<OrderItem> orderItemList = orderInfo.getOrderItemList();
            if (orderItemList == null) {
                orderItemList = new ArrayList<OrderItem>();
            }
            orderInfo.setOrderItemList(orderItemList);

            OrderItem orderItem = null;
            for (OrderItem savedItem : orderItemList) {
                if (savedItem.getProductCode().equals(productCode)) {
                    orderItem = savedItem;
                    break;
                }
            }

            if (orderItem == null) {
                orderItem = new OrderItem();
                orderItemList.add(orderItem);
            }
            orderItem.setQyt(qty);
            orderItem.setPrice(price);
            orderItem.setProductCode(productCode);
            orderInfo.setUserId(userId);
            orderRepository.save(orderInfo);
        }
    }

    public OrderInfo getNoCommitOrder(String userId) {
        List<OrderInfo> orderList = orderRepository.findByStatus(userId, 0);
        OrderInfo orderInfo = orderList != null && orderList.size() > 0 ? orderList.get(0) : null;
        return orderInfo;
    }

    public List<OrderInfo> getOrderByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public OrderInfo loadOrderItemData(OrderInfo orderInfo) {
        if (orderInfo != null) {
            List<OrderItem> orderItemList = orderInfo.getOrderItemList();
            if (orderItemList != null) {
                for (OrderItem orderItem : orderItemList) {
                    String productCode = orderItem.getProductCode();
                    orderItem.setProduct(productService.findByCode(productCode));
                }
            }
        }
        return orderInfo;
    }

    public Result submitOrder(String loginUserId, String orderId, String[] checkedProductCode, String name, String designation, String company, String companyAddress, String deliveryAddress, String contactNumber, String email) {
        OrderInfo orderInfo = orderRepository.findOne(orderId);
        if (orderInfo != null && orderInfo.getUserId() != null && orderInfo.getUserId().equals(loginUserId)) {
            List<OrderItem> orderItemList = orderInfo.getOrderItemList();
            if (orderItemList != null) {
                for (int i = 0; i < orderItemList.size(); i++) {
                    if (!contains(orderItemList.get(i), checkedProductCode)) {
                        //remove
                        orderItemList.remove(i);
                        i--;
                        continue;
                    }
                }
            }

            orderInfo.setOrderItemList(orderItemList);
            if (CollectionUtils.isEmpty(orderItemList)) {
                //TODO  ?
            }

            orderInfo.setName(name);
            orderInfo.setDesignation(designation);
            orderInfo.setCompany(company);
            orderInfo.setStatus(1);
            orderInfo.setCompanyAddress(companyAddress);
            orderInfo.setDeliveryAddress(deliveryAddress);
            orderInfo.setContactNumber(contactNumber);
            orderInfo.setEmail(email);
            orderRepository.save(orderInfo);
            return Result.result(1, "success", null);
        }
        return Result.result(0, "no such order", null);
    }

    private boolean contains(OrderItem orderItem, String[] checkedItemCode) {
        if (checkedItemCode != null) {
            for (String itemId : checkedItemCode) {
                if (itemId != null && itemId.equals(orderItem.getProductCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<OrderInfo> listAll() {
        return orderRepository.findAll();
    }

    public List<OrderInfo> attachUserInfo(List<OrderInfo> orderInfoList) {
        if (orderInfoList != null) {
            for (OrderInfo orderInfo : orderInfoList) {
                attachUserInfo(orderInfo);
            }
        }
        return orderInfoList;
    }

    public OrderInfo attachUserInfo(OrderInfo orderInfo) {
        String userId = orderInfo.getUserId();
        orderInfo.setUser(userService.findUser(userId));
        return orderInfo;
    }

    public OrderInfo getDetailById(String orderId) {
        return loadOrderItemData(orderRepository.findOne(orderId));
    }

    public Result addProduct(String userId, AddInfo[] addInfos) {
        if (addInfos != null) {
            for (AddInfo addInfo : addInfos) {
                if (addInfo != null) {
                    Product product = productService.findByCode(addInfo.getProductCode());
                    if (product != null) {
                        addProduct(userId, product.getCode(), addInfo.getQyt());
                    }
                }
            }
        }
        return Result.result(1, null, "success");
    }
}
