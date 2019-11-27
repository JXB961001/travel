package com.cn.travel.cms.strategy.provider;

import org.springframework.stereotype.Component;

@Component
public class StrategySqlProvider {

    public String count(){ return "SELECT count(*) FROM t_cms_strategy WHERE DELETE_STATUS=0"; }



    public String findById() {
        return "SELECT * FROM t_cms_strategy WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    public String findList(){
        return "SELECT * FROM t_cms_strategy WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String indexList(){
        return "SELECT * FROM t_cms_strategy WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }

    public String findListByQuery(){
        return "SELECT * FROM t_cms_strategy WHERE DELETE_STATUS=0 AND TITLE LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String update(){
        return "UPDATE t_cms_strategy SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),TITLE=#{title},IMG_URL=#{imgUrl}," +
                "RATING=#{rating},SUMMARY=#{summary},INTRO_URL=#{introUrl},STATE=#{state}" +
                " WHERE id=#{id}";
    }

    public String save(){
        return "INSERT INTO t_cms_strategy(ID,ADD_USER_ID,ADD_TIME,TITLE,IMG_URL,RATING,SUMMARY,INTRO_URL,STATE) " +
                "VALUES(#{id},#{addUserId},NOW(),#{title},#{imgUrl},#{rating},#{summary},#{introUrl},#{state})";
    }

    public String deleteByid(){
        return "UPDATE t_cms_strategy SET DELETE_STATUS=1 WHERE id=#{id}";
    }


    public String state0count(){ return "SELECT count(*) FROM t_cms_strategy WHERE DELETE_STATUS=0 AND STATE=0"; }

    public String state1count(){ return "SELECT count(*) FROM t_cms_strategy WHERE DELETE_STATUS=0 AND STATE=1"; }

    public String state2count(){ return "SELECT count(*) FROM t_cms_strategy WHERE DELETE_STATUS=0 AND STATE=2"; }
}
