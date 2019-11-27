package com.cn.travel.cms.message.service.imp;

import com.cn.travel.cms.message.dao.MessageDao;
import com.cn.travel.cms.message.entity.Message;
import com.cn.travel.cms.message.service.IMessageService;
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
public class MessageService implements IMessageService {

    @Resource
    private MessageDao messageDao;

    public long count()throws Exception{
        return  messageDao.count();
    }

    public long countByUserId(String userId)throws Exception{
        return  messageDao.countByUserId(userId);
    }

    public Message findById(String id)throws Exception{
        return messageDao.findById(id);
    }

    public List<Message> findList()throws Exception{
        return messageDao.findList();
    }

    public void save(Message article)throws Exception{
        messageDao.save(article);
    }

    public void update(Message article)throws Exception{
        messageDao.update(article);
    }
    public void deleteByid(String id)throws Exception{
        messageDao.deleteByid(id);
    }

    public List<Message> findByPage(int currentPage, int pageSize, String query) {
        List<Message> list = new ArrayList<Message>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = messageDao.findListByQuery("%" + query + "%");
        } else {
            list = messageDao.findList();
        }
        PageInfo<Message> pageInfo=new PageInfo<Message>(list);
        return pageInfo.getList();
    }

    public PageParam<Message> findByPageByUserId(int currentPage, int pageSize, String userId)throws Exception {
        PageParam<Message> pageParam = new PageParam<>();
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Message> list = messageDao.findListByUserId(userId);
        pageParam.setResult(list);
        pageParam.setSize(page.getPages());
        pageParam.setCount(page.getTotal());
        pageParam.setPageNumber(currentPage);
        pageParam.setPageSize(pageSize);
        return pageParam;
    }
}
