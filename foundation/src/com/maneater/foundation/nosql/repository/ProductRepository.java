package com.maneater.foundation.nosql.repository;

import com.maneater.foundation.nosql.entity.Product;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository extends BaseRepository<Product, String> {

    public List<Product> findByCategoryId(String categoryId) {
        return mongoTemplate.find(Query.query(Criteria.where("categoryId").is(categoryId)), Product.class);
    }

    public void syncCategoryName(String categoryId, String categoryName) {
        WriteResult result = mongoTemplate.updateMulti(Query.query(Criteria.where("categoryId").is(categoryId)), Update.update("categoryName", categoryName), Product.class);
//        return result != null && result.getError() == null;
    }

    public Product findByCode(String productCode) {
        List<Product> productList = mongoTemplate.find(Query.query(new Criteria().orOperator(Criteria.where("code").is(productCode), Criteria.where("propertyProductList").elemMatch(Criteria.where("productCode").is(productCode)))), Product.class);
        return productList != null && productList.size() > 0 ? productList.get(0) : null;
    }
}
