package com.cn.travel.cms.travelRoute.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.travelRoute.entity.TravelRoute;
import com.cn.travel.cms.travelRoute.provider.TravelRouteSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TravelRouteDao extends BaseDao<TravelRoute> {

    @SelectProvider(type = TravelRouteSqlProvider.class, method = "findById")
    public TravelRoute findById(@Param("id") String id);

    @SelectProvider(type = TravelRouteSqlProvider.class, method = "findList")
    public List<TravelRoute> findList();

    @SelectProvider(type = TravelRouteSqlProvider.class, method = "indexList")
    public List<TravelRoute> indexList();

    @SelectProvider(type = TravelRouteSqlProvider.class, method = "findListByQuery")
    public List<TravelRoute> findListByQuery(@Param("query") String query);

    @InsertProvider(type = TravelRouteSqlProvider.class, method = "save")
    public void save(TravelRoute articleClass);

    @UpdateProvider(type = TravelRouteSqlProvider.class, method = "update")
    public void update(TravelRoute articleClass);

    @UpdateProvider(type = TravelRouteSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

    @SelectProvider(type = TravelRouteSqlProvider.class, method = "count")
    public long count();

    @SelectProvider(type = TravelRouteSqlProvider.class, method = "count2")
    public long count2();

    @SelectProvider(type = TravelRouteSqlProvider.class, method = "state0count")
    public long state0count();
    @SelectProvider(type = TravelRouteSqlProvider.class, method = "state1count")
    public long state1count();
    @SelectProvider(type = TravelRouteSqlProvider.class, method = "state2count")
    public long state2count();
}
