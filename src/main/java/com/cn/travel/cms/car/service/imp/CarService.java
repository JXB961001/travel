package com.cn.travel.cms.car.service.imp;

import com.cn.travel.cms.car.dao.CarDao;
import com.cn.travel.cms.car.entity.Car;
import com.cn.travel.cms.car.service.ICarService;
import com.cn.travel.cms.strategy.dao.StrategyDao;
import com.cn.travel.cms.strategy.entity.Strategy;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService implements ICarService {

    @Resource
    private CarDao carDao;

    public long count()throws Exception{
        return  carDao.count();
    }


    public Car findById(String id)throws Exception{
        return carDao.findById(id);
    }

    public List<Car> findList()throws Exception{
        return carDao.findList();
    }

    public void save(Car car)throws Exception{
        carDao.save(car);
    }

    public void update(Car car)throws Exception{
        carDao.update(car);
    }
    public void deleteByid(String id)throws Exception{
        carDao.deleteByid(id);
    }

    public List<Car> findByPage(int currentPage, int pageSize, String query) {
        List<Car> list = new ArrayList<Car>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = carDao.findListByQuery("%" + query + "%");
        } else {
            list = carDao.findList();
        }
        PageInfo<Car> pageInfo=new PageInfo<Car>(list);
        return pageInfo.getList();
    }

    public List<Car> findByPage(int currentPage, int pageSize) {
        List<Car> list = new ArrayList<Car>();
        PageHelper.startPage(currentPage, pageSize);
        list = carDao.indexList();
        PageInfo<Car> pageInfo=new PageInfo<Car>(list);
        return pageInfo.getList();
    }


    public long state0count()throws Exception{
        return  carDao.state0count();
    }
    public long state1count()throws Exception{
        return  carDao.state1count();
    }
    public long state2count()throws Exception{
        return  carDao.state2count();
    }


    public long type0count()throws Exception{
        return  carDao.type0count();
    }
    public long type1count()throws Exception{
        return  carDao.type1count();
    }
    public long type2count()throws Exception{
        return  carDao.type2count();
    }
}
