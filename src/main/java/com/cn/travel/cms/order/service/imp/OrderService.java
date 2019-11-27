package com.cn.travel.cms.order.service.imp;

import com.cn.travel.cms.order.dao.OrderDao;
import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.cms.order.service.IOrderService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.PageParam;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Resource
    private OrderDao orderDao;

    public long count()throws Exception{
        return orderDao.count();
    }


    public Order findById(String id)throws Exception{
        return orderDao.findById(id);
    }

    public List<Order> findList()throws Exception{
        return orderDao.findList();
    }

    public void save(Order notice)throws Exception{
        orderDao.save(notice);
    }

    public void update(Order notice)throws Exception{
        orderDao.update(notice);
    }

    public void deleteByid(String id)throws Exception{
        orderDao.deleteByid(id);
    }

    public List<Order> findByPage(int currentPage, int pageSize, String query) {
        List<Order> list = new ArrayList<Order>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = orderDao.findListByQuery("%" + query + "%");
        } else {
            list = orderDao.findList();
        }
        PageInfo<Order> pageInfo=new PageInfo<Order>(list);
        return pageInfo.getList();
    }

    public List<Order> findListByUserId(String userId)throws Exception{
        return orderDao.findListByUserId(userId);
    }

    public long countByUserId(String userId)throws Exception{
        return orderDao.countByUserId(userId);
    }

    public PageParam<Order> findByPageByUserId(int currentPage, int pageSize, String userId)throws Exception{
        PageParam<Order> pageParam = new PageParam<>();
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Order> list = orderDao.findListByUserId(userId);
        pageParam.setResult(list);
        pageParam.setSize(page.getPages());
        pageParam.setCount(page.getTotal());
        pageParam.setPageNumber(currentPage);
        pageParam.setPageSize(pageSize);
        return pageParam;
    }



    public long state0count()throws Exception{
        return orderDao.state0count();
    }
    public long state1count()throws Exception{
        return orderDao.state1count();
    }
    public long state2count()throws Exception{
        return orderDao.state2count();
    }
}
