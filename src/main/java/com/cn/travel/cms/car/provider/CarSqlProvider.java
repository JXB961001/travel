package com.cn.travel.cms.car.provider;

import org.springframework.stereotype.Component;

@Component
public class CarSqlProvider {

    public String count(){ return "SELECT count(*) FROM t_cms_car WHERE DELETE_STATUS=0"; }



    public String findById() {
        return "SELECT * FROM t_cms_car WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    public String findList(){
        return "SELECT * FROM t_cms_car WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String indexList(){
        return "SELECT * FROM t_cms_car WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }

    public String findListByQuery(){
        return "SELECT * FROM t_cms_car WHERE DELETE_STATUS=0 AND TITLE LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String update(){
        return "UPDATE t_cms_car SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),TITLE=#{title}," +
                "START_PLACE=#{startPlace},END_PLACE=#{endPlace},START_DATE_AND_TIME=#{startDateAndTime},NEED_TIME=#{needTime},GATHER_PLACE=#{gatherPlace}," +
                "TYPE=#{type},PRICE=#{price},IMG_URL=#{imgUrl},STATE=#{state},REMARK=#{remark} WHERE id=#{id}";
    }

    public String save(){
        return "INSERT INTO t_cms_car(ID,ADD_USER_ID,ADD_TIME,TITLE,START_PLACE,END_PLACE,START_DATE_AND_TIME," +
                "NEED_TIME,GATHER_PLACE,TYPE,PRICE,IMG_URL,STATE,REMARK) VALUES(#{id},#{addUserId},NOW(),#{title},#{startPlace}," +
                "#{endPlace},#{startDateAndTime},#{needTime},#{gatherPlace},#{type},#{price},#{imgUrl},#{state},#{remark})";
    }

    public String deleteByid(){
        return "UPDATE t_cms_car SET DELETE_STATUS=1 WHERE id=#{id}";
    }

    public String state0count(){ return "SELECT count(*) FROM t_cms_car WHERE DELETE_STATUS=0 AND STATE=0"; }
    public String state1count(){ return "SELECT count(*) FROM t_cms_car WHERE DELETE_STATUS=0 AND STATE=1"; }
    public String state2count(){ return "SELECT count(*) FROM t_cms_car WHERE DELETE_STATUS=0 AND STATE=2"; }


    public String type0count(){ return "SELECT count(*) FROM t_cms_car WHERE DELETE_STATUS=0 AND TYPE=0"; }
    public String type1count(){ return "SELECT count(*) FROM t_cms_car WHERE DELETE_STATUS=0 AND TYPE=1"; }
    public String type2count(){ return "SELECT count(*) FROM t_cms_car WHERE DELETE_STATUS=0 AND TYPE=2"; }

}
