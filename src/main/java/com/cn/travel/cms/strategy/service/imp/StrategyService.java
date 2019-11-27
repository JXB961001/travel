package com.cn.travel.cms.strategy.service.imp;

import com.cn.travel.cms.scenicSpot.dao.ScenicSpotDao;
import com.cn.travel.cms.scenicSpot.entity.ScenicSpot;
import com.cn.travel.cms.strategy.dao.StrategyDao;
import com.cn.travel.cms.strategy.entity.Strategy;
import com.cn.travel.cms.strategy.service.IStrategyService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StrategyService implements IStrategyService{

    @Resource
    private StrategyDao strategyDao;

    public long count()throws Exception{
        return  strategyDao.count();
    }


    public Strategy findById(String id)throws Exception{
        return strategyDao.findById(id);
    }

    public List<Strategy> findList()throws Exception{
        return strategyDao.findList();
    }

    public void save(Strategy strategy)throws Exception{
        strategyDao.save(strategy);
    }

    public void update(Strategy strategy)throws Exception{
        strategyDao.update(strategy);
    }
    public void deleteByid(String id)throws Exception{
        strategyDao.deleteByid(id);
    }

    public List<Strategy> findByPage(int currentPage, int pageSize, String query) {
        List<Strategy> list = new ArrayList<Strategy>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = strategyDao.findListByQuery("%" + query + "%");
        } else {
            list = strategyDao.findList();
        }
        PageInfo<Strategy> pageInfo=new PageInfo<Strategy>(list);
        return pageInfo.getList();
    }

    public List<Strategy> findByPage(int currentPage, int pageSize) {
        List<Strategy> list = new ArrayList<Strategy>();
        PageHelper.startPage(currentPage, pageSize);
        list = strategyDao.indexList();
        PageInfo<Strategy> pageInfo=new PageInfo<Strategy>(list);
        return pageInfo.getList();
    }


    public long state0count()throws Exception{
        return  strategyDao.state0count();
    }
    public long state1count()throws Exception{
        return  strategyDao.state1count();
    }
    public long state2count()throws Exception{
        return  strategyDao.state2count();
    }
}
