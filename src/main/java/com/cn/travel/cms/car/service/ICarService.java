package com.cn.travel.cms.car.service;

import com.cn.travel.cms.car.entity.Car;
import com.cn.travel.cms.travelRoute.entity.TravelRoute;

import java.util.List;

public interface ICarService {
    public long count()throws Exception;

    public Car findById(String id)throws Exception;

    public List<Car> findList()throws Exception;

    public void save(Car car)throws Exception;

    public void update(Car car)throws Exception;

    public void deleteByid(String id)throws Exception;

    public List<Car> findByPage(int currentPage, int pageSize, String query)throws Exception;

    public List<Car> findByPage(int currentPage, int pageSize)throws Exception;
}
