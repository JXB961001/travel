package com.cn.travel.role.user.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.role.user.entity.Porvice;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao extends BaseDao<User> {

    @SelectProvider(type = UserSqlProvider.class, method = "count")
    public long count();

    @SelectProvider(type = UserSqlProvider.class, method = "login")
    public User login(@Param("userName") String userName, @Param("password") String password);

    @SelectProvider(type = UserSqlProvider.class, method = "findById")
    public User findById(@Param("id") String id);

    @SelectProvider(type = UserSqlProvider.class, method = "findByUserName")
    public User findByUserName(@Param("userName") String userName);

    @SelectProvider(type = UserSqlProvider.class, method = "findList")
    public List<User> findList();

    @SelectProvider(type = UserSqlProvider.class, method = "findListByQuery")
    public List<User> findListByQuery(@Param("query") String query);

    @InsertProvider(type = UserSqlProvider.class, method = "save")
    public void save(User user);

    @UpdateProvider(type = UserSqlProvider.class, method = "update")
    public void update(User user);

    @UpdateProvider(type = UserSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id")String id);

    @SelectProvider(type = UserSqlProvider.class, method = "countPorvice")
    public List<Porvice> countPorvice();

    @SelectProvider(type = UserSqlProvider.class, method = "state1count")
    public long state1count();

    @SelectProvider(type = UserSqlProvider.class, method = "state2count")
    public long state2count();

}
