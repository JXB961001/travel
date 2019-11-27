package com.cn.travel.role.admin.service.imp;

import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.cn.travel.role.admin.dao.AdminDao;
import com.cn.travel.role.admin.entity.Admin;
import com.cn.travel.role.admin.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Resource
    private AdminDao adminDao;

    public long count()throws Exception{
        return adminDao.count();
    }

    public Admin login(String userName,String password)throws Exception{
        return adminDao.login(userName,password);
    }

    public Admin findByUserName(String userName){
        return adminDao.findByUserName(userName);
    }

    public Admin findById(String id)throws Exception{
        return adminDao.findById(id);
    }

    public List<Admin> findList()throws Exception{
        return adminDao.findList();
    }

    public void save(Admin admin)throws Exception{
        adminDao.save(admin);
    }

    public void update(Admin admin)throws Exception{
        adminDao.update(admin);
    }

    public void deleteByid(String id)throws Exception{
        adminDao.deleteByid(id);
    }

    public List<Admin> findByPage(int currentPage,int pageSize, String query) {
        List<Admin> list = new ArrayList<Admin>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = adminDao.findListByQuery("%" + query + "%");
        } else {
            list = adminDao.findList();
        }
        PageInfo<Admin> pageInfo=new PageInfo<Admin>(list);
        return pageInfo.getList();
    }
}
