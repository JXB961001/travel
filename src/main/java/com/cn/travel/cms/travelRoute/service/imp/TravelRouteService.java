package com.cn.travel.cms.travelRoute.service.imp;

import com.cn.travel.cms.travelRoute.dao.TravelRouteDao;
import com.cn.travel.cms.travelRoute.entity.TravelRoute;
import com.cn.travel.cms.travelRoute.service.ITravelRouteService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TravelRouteService implements ITravelRouteService {

    @Resource
    private TravelRouteDao travelRouteDao;

    public long count()throws Exception{
        return travelRouteDao.count();
    }

    public long count2()throws Exception{
        return travelRouteDao.count2();
    }

    public TravelRoute findById(String id)throws Exception{
        return travelRouteDao.findById(id);
    }

    public List<TravelRoute> findList()throws Exception{
        return travelRouteDao.findList();
    }

    public void save(TravelRoute travelRoute)throws Exception{
        travelRouteDao.save(travelRoute);
    }

    public void update(TravelRoute travelRoute)throws Exception{
        travelRouteDao.update(travelRoute);
    }

    public void deleteByid(String id)throws Exception{
        travelRouteDao.deleteByid(id);
    }

    public List<TravelRoute> findByPage(int currentPage, int pageSize, String query) {
        List<TravelRoute> list = new ArrayList<TravelRoute>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = travelRouteDao.findListByQuery("%" + query + "%");
        } else {
            list = travelRouteDao.findList();
        }
        PageInfo<TravelRoute> pageInfo=new PageInfo<TravelRoute>(list);
        return pageInfo.getList();
    }

    public List<TravelRoute> findByPage(int currentPage, int pageSize) {
        List<TravelRoute> list = new ArrayList<TravelRoute>();
        PageHelper.startPage(currentPage, pageSize);
        list = travelRouteDao.indexList();
        PageInfo<TravelRoute> pageInfo=new PageInfo<TravelRoute>(list);
        return pageInfo.getList();
    }

    public long state0count()throws Exception{
        return travelRouteDao.state0count();
    }

    public long state1count()throws Exception{
        return travelRouteDao.state1count();
    }

    public long state2count()throws Exception{
        return travelRouteDao.state2count();
    }
}
