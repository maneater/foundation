package com.maneater.foundation.repository;

import com.maneater.foundation.entity.GraphModel;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
public interface GraphModelRepository extends BaseRepository<GraphModel> {
    public List<GraphModel> findBySupplierId(long supplierId);
}
