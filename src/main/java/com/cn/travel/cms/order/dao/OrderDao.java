package com.cn.travel.cms.order.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.cms.order.provider.OrderSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderDao extends BaseDao<Order> {

    @SelectProvider(type = OrderSqlProvider.class, method = "findById")
    public Order findById(@Param("id") String id);

    @SelectProvider(type = OrderSqlProvider.class, method = "findList")
    public List<Order> findList();

    @SelectProvider(type = OrderSqlProvider.class, method = "findListByQuery")
    public List<Order> findListByQuery(@Param("query") String query);

    @SelectProvider(type = OrderSqlProvider.class, method = "findListByUserId")
    public List<Order> findListByUserId(@Param("userId") String userId);

    @InsertProvider(type = OrderSqlProvider.class, method = "save")
    public void save(Order notice);

    @UpdateProvider(type = OrderSqlProvider.class, method = "update")
    public void update(Order notice);

    @UpdateProvider(type = OrderSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

    @SelectProvider(type = OrderSqlProvider.class, method = "count")
    public long count();

    @SelectProvider(type = OrderSqlProvider.class, method = "countByUserId")
    public long countByUserId(@Param("userId") String userId);

    @SelectProvider(type = OrderSqlProvider.class, method = "state0count")
    public long state0count();
    @SelectProvider(type = OrderSqlProvider.class, method = "state1count")
    public long state1count();
    @SelectProvider(type = OrderSqlProvider.class, method = "state2count")
    public long state2count();
}
