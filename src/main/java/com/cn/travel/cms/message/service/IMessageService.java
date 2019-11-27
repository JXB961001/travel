package com.cn.travel.cms.message.service;

import com.cn.travel.cms.message.entity.Message;
import com.cn.travel.web.base.PageParam;

import java.util.List;

public interface IMessageService {

    public long count()throws Exception;

    public long countByUserId(String userId)throws Exception;

    public Message findById(String id)throws Exception;

    public List<Message> findList()throws Exception;

    public void save(Message article)throws Exception;

    public void update(Message article)throws Exception;

    public void deleteByid(String id)throws Exception;

    public List<Message> findByPage(int currentPage, int pageSize, String query)throws Exception;

    public PageParam<Message> findByPageByUserId(int currentPage, int pageSize, String userId)throws Exception;
}
