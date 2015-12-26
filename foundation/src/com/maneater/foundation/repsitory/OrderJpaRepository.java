package com.maneater.foundation.repsitory;


import com.maneater.foundation.nosql.entity.OrderInfo;
import com.maneater.foundation.nosql.repository.BaseRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderJpaRepository extends JpaBaseRepository<OrderInfo> {

    public List<OrderInfo> findByUserIdAndStatus(String userId, int status);

    public List<OrderInfo> findByUserId(String userId);

}
