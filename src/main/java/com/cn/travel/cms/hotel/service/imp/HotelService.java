package com.cn.travel.cms.hotel.service.imp;

import com.cn.travel.cms.hotel.dao.HotelDao;
import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.hotel.service.IHotelService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {

    @Resource
    private HotelDao hotelDao;

    public long count()throws Exception{
        return  hotelDao.count();
    }

    public long count2()throws Exception{
        return  hotelDao.count2();
    }

    public Hotel findById(String id)throws Exception{
        return hotelDao.findById(id);
    }

    public List<Hotel> findList()throws Exception{
        return hotelDao.findList();
    }

    public void save(Hotel article)throws Exception{
        hotelDao.save(article);
    }

    public void update(Hotel article)throws Exception{
        hotelDao.update(article);
    }
    public void deleteByid(String id)throws Exception{
        hotelDao.deleteByid(id);
    }

    public List<Hotel> findByPage(int currentPage, int pageSize, String query) {
        List<Hotel> list = new ArrayList<Hotel>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = hotelDao.findListByQuery("%" + query + "%");
        } else {
            list = hotelDao.findList();
        }
        PageInfo<Hotel> pageInfo=new PageInfo<Hotel>(list);
        return pageInfo.getList();
    }

    public List<Hotel> findByPage(int currentPage, int pageSize) {
        List<Hotel> list = new ArrayList<Hotel>();
        PageHelper.startPage(currentPage, pageSize);
        list = hotelDao.indexList();
        PageInfo<Hotel> pageInfo=new PageInfo<Hotel>(list);
        return pageInfo.getList();
    }

    public long state0count()throws Exception{
        return  hotelDao.state0count();
    }
    public long state1count()throws Exception{
        return  hotelDao.state1count();
    }
    public long state2count()throws Exception{
        return  hotelDao.state2count();
    }
}
