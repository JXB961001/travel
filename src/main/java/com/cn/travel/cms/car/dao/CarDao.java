package com.cn.travel.cms.car.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.car.entity.Car;
import com.cn.travel.cms.car.provider.CarSqlProvider;
import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.hotel.provider.HotelSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CarDao  extends BaseDao<Car> {
    @SelectProvider(type = CarSqlProvider.class, method = "findById")
    public Car findById(@Param("id") String id);

    @SelectProvider(type = CarSqlProvider.class, method = "findList")
    public List<Car> findList();

    @SelectProvider(type = CarSqlProvider.class, method = "indexList")
    public List<Car> indexList();

    @SelectProvider(type = CarSqlProvider.class, method = "findListByQuery")
    public List<Car> findListByQuery(@Param("query") String query);

    @InsertProvider(type = CarSqlProvider.class, method = "save")
    public void save(Car car);

    @UpdateProvider(type = CarSqlProvider.class, method = "update")
    public void update(Car car);

    @UpdateProvider(type = CarSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

    @SelectProvider(type = CarSqlProvider.class, method = "count")
    public long count();


    @SelectProvider(type = CarSqlProvider.class, method = "state0count")
    public long state0count();
    @SelectProvider(type = CarSqlProvider.class, method = "state1count")
    public long state1count();
    @SelectProvider(type = CarSqlProvider.class, method = "state2count")
    public long state2count();


    @SelectProvider(type = CarSqlProvider.class, method = "type0count")
    public long type0count();
    @SelectProvider(type = CarSqlProvider.class, method = "type1count")
    public long type1count();
    @SelectProvider(type = CarSqlProvider.class, method = "type2count")
    public long type2count();
}
