package com.cn.travel.role.admin.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.role.admin.entity.Admin;
import com.cn.travel.role.admin.provider.AdminSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminDao extends BaseDao<Admin> {

    @SelectProvider(type = AdminSqlProvider.class, method = "count")
    public long count();

    @SelectProvider(type = AdminSqlProvider.class, method = "login")
    public Admin login(@Param("userName") String userName, @Param("password") String password);

    @SelectProvider(type = AdminSqlProvider.class, method = "findByUserName")
    public Admin findByUserName(@Param("userName") String userName);

    @SelectProvider(type = AdminSqlProvider.class, method = "findById")
    public Admin findById(@Param("id") String id);

    @SelectProvider(type = AdminSqlProvider.class, method = "findList")
    public List<Admin> findList();

    @SelectProvider(type = AdminSqlProvider.class, method = "findListByQuery")
    public List<Admin> findListByQuery(@Param("query") String query);

    @InsertProvider(type = AdminSqlProvider.class, method = "save")
    public void save(Admin admin);

    @UpdateProvider(type = AdminSqlProvider.class, method = "update")
    public void update(Admin admin);

    @UpdateProvider(type = AdminSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

}
