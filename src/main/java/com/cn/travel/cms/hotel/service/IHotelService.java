package com.cn.travel.cms.hotel.service;

import com.cn.travel.cms.hotel.entity.Hotel;

import java.util.List;

public interface IHotelService {

    public long count()throws Exception;

    public Hotel findById(String id)throws Exception;

    public List<Hotel> findList()throws Exception;

    public void save(Hotel article)throws Exception;

    public void update(Hotel article)throws Exception;

    public void deleteByid(String id)throws Exception;

    public List<Hotel> findByPage(int currentPage, int pageSize, String query)throws Exception;

    public List<Hotel> findByPage(int currentPage, int pageSize)throws Exception;
}
