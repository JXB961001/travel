package com.cn.travel.cms.order.service;

import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.web.base.PageParam;

import java.util.List;

public interface IOrderService {

    public long count()throws Exception;

    public Order findById(String id)throws Exception;

    public List<Order> findList()throws Exception;

    public void save(Order notice)throws Exception;

    public void update(Order notice)throws Exception;

    public void deleteByid(String id)throws Exception;

    public List<Order> findByPage(int currentPage, int pageSize, String query)throws Exception;

    public List<Order> findListByUserId(String userId)throws Exception;

    public long countByUserId(String userId)throws Exception;

    public PageParam<Order> findByPageByUserId(int currentPage, int pageSize, String userId)throws Exception;
}
