package com.cn.travel.cms.hotel.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.hotel.provider.HotelSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HotelDao extends BaseDao<Hotel> {

    @SelectProvider(type = HotelSqlProvider.class, method = "findById")
    public Hotel findById(@Param("id") String id);

    @SelectProvider(type = HotelSqlProvider.class, method = "findList")
    public List<Hotel> findList();

    @SelectProvider(type = HotelSqlProvider.class, method = "indexList")
    public List<Hotel> indexList();

    @SelectProvider(type = HotelSqlProvider.class, method = "findListByQuery")
    public List<Hotel> findListByQuery(@Param("query") String query);

    @InsertProvider(type = HotelSqlProvider.class, method = "save")
    public void save(Hotel article);

    @UpdateProvider(type = HotelSqlProvider.class, method = "update")
    public void update(Hotel article);

    @UpdateProvider(type = HotelSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

    @SelectProvider(type = HotelSqlProvider.class, method = "count")
    public long count();

    @SelectProvider(type = HotelSqlProvider.class, method = "count2")
    public long count2();

    @SelectProvider(type = HotelSqlProvider.class, method = "state0count")
    public long state0count();
    @SelectProvider(type = HotelSqlProvider.class, method = "state1count")
    public long state1count();
    @SelectProvider(type = HotelSqlProvider.class, method = "state2count")
    public long state2count();

}
