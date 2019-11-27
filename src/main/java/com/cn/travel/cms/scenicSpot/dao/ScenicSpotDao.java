package com.cn.travel.cms.scenicSpot.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.scenicSpot.entity.ScenicSpot;
import com.cn.travel.cms.scenicSpot.provider.ScenicSpotSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ScenicSpotDao extends BaseDao<ScenicSpot> {

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "findById")
    public ScenicSpot findById(@Param("id") String id);

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "findList")
    public List<ScenicSpot> findList();

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "indexList")
    public List<ScenicSpot> indexList();

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "findListByQuery")
    public List<ScenicSpot> findListByQuery(@Param("query") String query);

    @InsertProvider(type = ScenicSpotSqlProvider.class, method = "save")
    public void save(ScenicSpot article);

    @UpdateProvider(type = ScenicSpotSqlProvider.class, method = "update")
    public void update(ScenicSpot article);

    @UpdateProvider(type = ScenicSpotSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "count")
    public long count();

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "count2")
    public long count2();

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "state0count")
    public long state0count();
    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "state1count")
    public long state1count();
    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "state2count")
    public long state2count();
}
