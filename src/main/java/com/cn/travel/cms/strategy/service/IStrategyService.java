package com.cn.travel.cms.strategy.service;

import com.cn.travel.cms.scenicSpot.entity.ScenicSpot;
import com.cn.travel.cms.strategy.entity.Strategy;

import java.util.List;

public interface IStrategyService {
    public long count()throws Exception;



    public Strategy findById(String id)throws Exception;

    public List<Strategy> findList()throws Exception;

    public void save(Strategy strategy)throws Exception;

    public void update(Strategy strategy)throws Exception;

    public void deleteByid(String id)throws Exception;

    public List<Strategy> findByPage(int currentPage, int pageSize, String query)throws Exception;

    public List<Strategy> findByPage(int currentPage, int pageSize)throws Exception;
}
