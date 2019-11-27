package com.cn.travel.cms.strategy.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.scenicSpot.entity.ScenicSpot;
import com.cn.travel.cms.scenicSpot.provider.ScenicSpotSqlProvider;
import com.cn.travel.cms.strategy.entity.Strategy;
import com.cn.travel.cms.strategy.provider.StrategySqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StrategyDao extends BaseDao<Strategy> {
    @SelectProvider(type = StrategySqlProvider.class, method = "findById")
    public Strategy findById(@Param("id") String id);

    @SelectProvider(type = StrategySqlProvider.class, method = "findList")
    public List<Strategy> findList();

    @SelectProvider(type = StrategySqlProvider.class, method = "indexList")
    public List<Strategy> indexList();

    @SelectProvider(type = StrategySqlProvider.class, method = "findListByQuery")
    public List<Strategy> findListByQuery(@Param("query") String query);

    @InsertProvider(type = StrategySqlProvider.class, method = "save")
    public void save(Strategy article);

    @UpdateProvider(type = StrategySqlProvider.class, method = "update")
    public void update(Strategy article);

    @UpdateProvider(type = StrategySqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

    @SelectProvider(type = StrategySqlProvider.class, method = "count")
    public long count();



    @SelectProvider(type = StrategySqlProvider.class, method = "state0count")
    public long state0count();

    @SelectProvider(type = StrategySqlProvider.class, method = "state1count")
    public long state1count();

    @SelectProvider(type = StrategySqlProvider.class, method = "state2count")
    public long state2count();
}
