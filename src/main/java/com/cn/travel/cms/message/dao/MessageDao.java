package com.cn.travel.cms.message.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.message.entity.Message;
import com.cn.travel.cms.message.provider.MessageSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageDao extends BaseDao<Message> {

    @SelectProvider(type = MessageSqlProvider.class, method = "findById")
    public Message findById(@Param("id") String id);

    @SelectProvider(type = MessageSqlProvider.class, method = "findList")
    public List<Message> findList();

    @SelectProvider(type = MessageSqlProvider.class, method = "findListByUserId")
    public List<Message> findListByUserId(@Param("userId") String userId);

    @SelectProvider(type = MessageSqlProvider.class, method = "findListByQuery")
    public List<Message> findListByQuery(@Param("query") String query);

    @InsertProvider(type = MessageSqlProvider.class, method = "save")
    public void save(Message article);

    @UpdateProvider(type = MessageSqlProvider.class, method = "update")
    public void update(Message article);

    @UpdateProvider(type = MessageSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id") String id);

    @SelectProvider(type = MessageSqlProvider.class, method = "count")
    public long count();

    @SelectProvider(type = MessageSqlProvider.class, method = "countByUserId")
    public long countByUserId(@Param("userId") String userId);

}
