package com.cn.travel.role.user.service.imp;

import com.cn.travel.role.user.dao.UserDao;
import com.cn.travel.role.user.entity.Porvice;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.service.IUserService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;

    public long count()throws Exception{
        return userDao.count();
    }

    public User login(String userName,String password)throws Exception{
        return userDao.login(userName,password);
    }

    public User findById(String id)throws Exception{
        return userDao.findById(id);
    }

    public User findByUserName(String userName)throws Exception{
        return userDao.findByUserName(userName);
    }

    public List<User> findList()throws Exception{
        return userDao.findList();
    }

    public void save(User user)throws Exception{
        userDao.save(user);
    }

    public void update(User user)throws Exception{
        userDao.update(user);
    }
    public void deleteByid(String id)throws Exception{
        userDao.deleteByid(id);
    }

    public List<User> findByPage(int currentPage,int pageSize, String query) {
        List<User> list = new ArrayList<User>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = userDao.findListByQuery("%" + query + "%");
        } else {
            list = userDao.findList();
        }
        PageInfo<User> pageInfo=new PageInfo<User>(list);
        return pageInfo.getList();
    }

    public List<Porvice> countPorvice()throws Exception{
        return userDao.countPorvice();
    }

    public long state1count()throws Exception{
        return userDao.state1count();
    }

    public long state2count()throws Exception{
        return userDao.state2count();
    }
}
