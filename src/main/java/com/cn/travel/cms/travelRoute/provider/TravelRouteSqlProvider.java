package com.cn.travel.cms.travelRoute.provider;

import org.springframework.stereotype.Component;

@Component
public class TravelRouteSqlProvider {

    public String count(){ return "SELECT count(*) FROM t_cms_travel_route WHERE DELETE_STATUS=0"; }

    public String count2(){ return "SELECT count(*) FROM t_cms_travel_route WHERE DELETE_STATUS=0 AND STATE=1"; }

    public String findById() {
        return "SELECT * FROM t_cms_travel_route WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    public String findList(){
        return "SELECT * FROM t_cms_travel_route WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String indexList(){
        return "SELECT * FROM t_cms_travel_route WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }

    public String findListByQuery(){
        return "SELECT * FROM t_cms_travel_route WHERE DELETE_STATUS=0 AND TITLE LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String update(){
        return "UPDATE t_cms_travel_route SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),TITLE=#{title}," +
                "START_SITE=#{startSite},END_SITE=#{endSite},END_TIME=#{endTime},START_TIME=#{startTime},DAY=#{day}," +
                "PRODUCT_CODE=#{productCode},PRICE=#{price},STATE=#{state},IMG_URL=#{imgUrl},INTRO=#{intro} WHERE id=#{id}";
    }

    public String save(){
        return "INSERT INTO t_cms_travel_route(ID,ADD_USER_ID,ADD_TIME,TITLE,START_SITE,END_SITE,END_TIME," +
                "START_TIME,DAY,PRODUCT_CODE,PRICE,STATE,IMG_URL,INTRO) VALUES(#{id},#{addUserId},NOW(),#{title},#{startSite}," +
                "#{endSite},#{endTime},#{startTime},#{day},#{productCode},#{price},#{state},#{imgUrl},#{intro})";
    }

    public String deleteByid(){
        return "UPDATE t_cms_travel_route SET DELETE_STATUS=1 WHERE id=#{id}";
    }

    public String state0count(){ return "SELECT count(*) FROM t_cms_travel_route WHERE DELETE_STATUS=0 AND STATE=0"; }
    public String state1count(){ return "SELECT count(*) FROM t_cms_travel_route WHERE DELETE_STATUS=0 AND STATE=1"; }
    public String state2count(){ return "SELECT count(*) FROM t_cms_travel_route WHERE DELETE_STATUS=0 AND STATE=2"; }

}
