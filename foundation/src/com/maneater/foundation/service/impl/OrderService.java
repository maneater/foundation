package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.OrderInfo;
import com.maneater.foundation.nosql.entity.OrderItem;
import com.maneater.foundation.nosql.entity.Product;
import com.maneater.foundation.nosql.entity.Room;
import com.maneater.foundation.nosql.repository.OrderRepository;
import com.maneater.foundation.vo.AddInfo;
import com.maneater.foundation.vo.Result;
import org.springframework.stereotype.Service;

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


    public Result submitOrder(String loginUserId, String orderId, List<AddInfo> addInfoList, String name, String designation, String company, String companyAddress, String deliveryAddress, String contactNumber, String email) {
        OrderInfo orderInfo = orderRepository.findOne(orderId);
        if (orderInfo != null && orderInfo.getUserId() != null && orderInfo.getUserId().equals(loginUserId)) {

            if (orderInfo.getStatus() != 0) {
                return Result.result(0, String.format("order has be submitted at : %1$s", orderInfo.getLastUpdateTime()), null);
            }

            List<OrderItem> addOrderItemList = new ArrayList<OrderItem>();
            if (addInfoList != null) {
                for (AddInfo addInfo : addInfoList) {
                    //忽略
                    if (addInfo == null || addInfo.getProductCode() == null || addInfo.getChecked() == 0 || addInfo.getQyt() == 0) {
                        continue;
                    }
                    Product product = productService.findByCode(addInfo.getProductCode());
                    if (product == null) {
                        return Result.result(0, String.format("no such product code : %1$s", addInfo.getProductCode()), null);
                    } else {
                        OrderItem orderItem = new OrderItem();
                        orderItem.setProductCode(addInfo.getProductCode());
                        orderItem.setQyt(addInfo.getQyt());
                        orderItem.setPrice(product.getPriceByCode(addInfo.getProductCode()));
                        addOrderItemList.add(orderItem);
                    }
                }
            }
            if (addOrderItemList.size() == 0) {
                return Result.result(0, "no product was selected by this order", null);
            }

            orderInfo.setOrderItemList(addOrderItemList);
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

//    private boolean contains(OrderItem orderItem, String[] checkedItemCode) {
//        if (checkedItemCode != null) {
//            for (String itemId : checkedItemCode) {
//                if (itemId != null && itemId.equals(orderItem.getProductCode())) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

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
                        addProduct(userId, addInfo.getProductCode(), addInfo.getQyt());
                    }
                }
            }
        }
        return Result.result(1, "success", null);
    }

    @Resource
    private RoomService roomService = null;

    public Result confirmRoom(String loginUserId, String roomId, int roomNum) {

        Room room = roomService.findById(roomId);
        if (room == null) {
            return Result.result(0, "no such room", null);
        }

        OrderInfo orderInfo = getNoCommitOrder(loginUserId);
        if (orderInfo == null) {
            orderInfo = new OrderInfo();
            orderInfo.setUserId(loginUserId);
        }

        orderInfo.setRoomId(roomId);
        orderInfo.setRoomNumbers(roomNum);
        orderRepository.save(orderInfo);
        return Result.result(1, "success", null);
    }
}
