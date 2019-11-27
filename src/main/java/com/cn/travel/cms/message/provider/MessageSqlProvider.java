package com.cn.travel.cms.message.provider;

import org.springframework.stereotype.Component;

@Component
public class MessageSqlProvider {

    public String count(){ return "SELECT count(*) FROM t_cms_message WHERE DELETE_STATUS=0"; }

    public String countByUserId(){ return "SELECT count(*) FROM t_cms_message WHERE USER_ID = #{userId} AND DELETE_STATUS=0"; }

    public String findListByUserId(){
        return "SELECT * FROM t_cms_message WHERE USER_ID=#{userId} AND DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String findById() {
        return "SELECT * FROM t_cms_message WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    public String findList(){
        return "SELECT * FROM t_cms_message WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String findListByQuery(){
        return "SELECT * FROM t_cms_message WHERE DELETE_STATUS=0 AND USER_NAME LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String update(){
        return "UPDATE t_cms_message SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),USER_ID=#{userId}," +
                "USER_NAME=#{userName},NAME=#{name},TITLE=#{title},CONTENT=#{content},STATE=#{state} WHERE id=#{id}";
    }

    public String save(){
        return "INSERT INTO t_cms_message(ID,ADD_USER_ID,ADD_TIME,USER_ID,USER_NAME,NAME,TITLE,CONTENT,STATE) " +
                "VALUES(#{id},#{addUserId},NOW(),#{userId},#{userName},#{name},#{title},#{content},#{state})";
    }

    public String deleteByid(){
        return "UPDATE t_cms_message SET DELETE_STATUS=1 WHERE id=#{id}";
    }

}
