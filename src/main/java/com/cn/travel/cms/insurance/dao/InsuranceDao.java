package com.cn.travel.cms.insurance.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.hotel.provider.HotelSqlProvider;
import com.cn.travel.cms.insurance.entity.Insurance;
import com.cn.travel.cms.insurance.provider.InsuranceSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface InsuranceDao extends BaseDao<Insurance> {
    @SelectProvider(type = InsuranceSqlProvider.class, method = "findById")
    public Insurance findById(@Param("id") String id);

    @SelectProvider(type = InsuranceSqlProvider.class, method = "findList")
    public List<Insurance> findList();

    @SelectProvider(type = InsuranceSqlProvider.class, method = "indexList")
    public List<Insurance> indexList();

    @SelectProvider(type = InsuranceSqlProvider.class, method = "findListByQuery")
    public List<Insurance> findListByQuery(@Param("query") String query);

    @InsertProvider(type = InsuranceSqlProvider.class, method = "save")
    public void save(Insurance article);

    @UpdateProvider(type = InsuranceSqlProvider.class, method = "update")
    public void update(Insurance article);

    @UpdateProvider(type = InsuranceSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

    @SelectProvider(type = InsuranceSqlProvider.class, method = "count")
    public long count();



    @SelectProvider(type = InsuranceSqlProvider.class, method = "state0count")
    public long state0count();
    @SelectProvider(type = InsuranceSqlProvider.class, method = "state1count")
    public long state1count();
    @SelectProvider(type = InsuranceSqlProvider.class, method = "state2count")
    public long state2count();


    @SelectProvider(type = InsuranceSqlProvider.class, method = "company0count")
    public long company0count();
    @SelectProvider(type = InsuranceSqlProvider.class, method = "company1count")
    public long company1count();
}
