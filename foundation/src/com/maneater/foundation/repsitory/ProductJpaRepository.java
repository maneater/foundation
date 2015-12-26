package com.maneater.foundation.repsitory;

import com.maneater.foundation.nosql.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaBaseRepository<Product> {

    public List<Product> findByCategoryId(String categoryId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update Product product set product.categoryName=:categoryName where product.categoryId=:categoryId")
    public void syncCategoryName(@Param("categoryId") String categoryId,@Param("categoryName") String categoryName);

    @Query(value = "SELECT product FROM Product product inner join product.propertyProductList pproduct where ( (product.code=:productCode or pproduct.productCode=:productCode))")
    public List<Product> findByCode(@Param("productCode") String productCode);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update Product product set product.enable=:enable where product.id=:id")
    public Integer setEnableStatus(@Param("id") String id, @Param("enable") boolean enable);

}
