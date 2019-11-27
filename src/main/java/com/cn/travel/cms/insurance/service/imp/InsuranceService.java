package com.cn.travel.cms.insurance.service.imp;


import com.cn.travel.cms.insurance.dao.InsuranceDao;
import com.cn.travel.cms.insurance.entity.Insurance;
import com.cn.travel.cms.insurance.service.IInsuranceService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceService implements IInsuranceService {
    @Resource
    private InsuranceDao insuranceDao;

    public long count()throws Exception{
        return  insuranceDao.count();
    }



    public Insurance findById(String id)throws Exception{
        return insuranceDao.findById(id);
    }

    public List<Insurance> findList()throws Exception{
        return insuranceDao.findList();
    }

    public void save(Insurance article)throws Exception{
        insuranceDao.save(article);
    }

    public void update(Insurance article)throws Exception{
        insuranceDao.update(article);
    }
    public void deleteByid(String id)throws Exception{
        insuranceDao.deleteByid(id);
    }

    public List<Insurance> findByPage(int currentPage, int pageSize, String query) {
        List<Insurance> list = new ArrayList<Insurance>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = insuranceDao.findListByQuery("%" + query + "%");
        } else {
            list = insuranceDao.findList();
        }
        PageInfo<Insurance> pageInfo=new PageInfo<Insurance>(list);
        return pageInfo.getList();
    }

    public List<Insurance> findByPage(int currentPage, int pageSize) {
        List<Insurance> list = new ArrayList<Insurance>();
        PageHelper.startPage(currentPage, pageSize);
        list = insuranceDao.indexList();
        PageInfo<Insurance> pageInfo=new PageInfo<Insurance>(list);
        return pageInfo.getList();
    }

    public long state0count()throws Exception{
        return  insuranceDao.state0count();
    }
    public long state1count()throws Exception{
        return  insuranceDao.state1count();
    }
    public long state2count()throws Exception{
        return  insuranceDao.state2count();
    }

    public long company0count()throws Exception{
        return  insuranceDao.company0count();
    }
    public long company1count()throws Exception{
        return  insuranceDao.company1count();
    }
}
