package com.cn.travel.cms.insurance.service;

import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.insurance.entity.Insurance;

import java.util.List;

public interface IInsuranceService {
    public long count()throws Exception;

    public Insurance findById(String id)throws Exception;

    public List<Insurance> findList()throws Exception;

    public void save(Insurance article)throws Exception;

    public void update(Insurance article)throws Exception;

    public void deleteByid(String id)throws Exception;

    public List<Insurance> findByPage(int currentPage, int pageSize, String query)throws Exception;

    public List<Insurance> findByPage(int currentPage, int pageSize)throws Exception;
}
