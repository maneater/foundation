package com.maneater.foundation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maneater.foundation.entity.SiteInfo;

public interface SiteInfoDao extends JpaRepository<SiteInfo, Long> {

}
