package com.cn.travel.cms.travelRoute.service;

import com.cn.travel.cms.travelRoute.entity.TravelRoute;

import java.util.List;

public interface ITravelRouteService {

    public long count()throws Exception;

    public TravelRoute findById(String id)throws Exception;

    public List<TravelRoute> findList()throws Exception;

    public void save(TravelRoute travelRoute)throws Exception;

    public void update(TravelRoute travelRoute)throws Exception;

    public void deleteByid(String id)throws Exception;

    public List<TravelRoute> findByPage(int currentPage, int pageSize, String query)throws Exception;

    public List<TravelRoute> findByPage(int currentPage, int pageSize)throws Exception;
}
