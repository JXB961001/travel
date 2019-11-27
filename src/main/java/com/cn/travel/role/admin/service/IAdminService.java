package com.cn.travel.role.admin.service;

import com.cn.travel.role.admin.entity.Admin;

import java.util.List;

public interface IAdminService {

    public long count()throws Exception;

    public Admin login(String userName, String password)throws Exception;

    public Admin findById(String id)throws Exception;

    public List<Admin> findList()throws Exception;

    public void save(Admin admin)throws Exception;

    public void update(Admin admin)throws Exception;

    public void deleteByid(String id)throws Exception;

    public List<Admin> findByPage(int currentPage,int pageSize, String query)throws Exception;
}
