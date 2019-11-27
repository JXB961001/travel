package com.cn.travel.cms.hotel.provider;

import org.springframework.stereotype.Component;

@Component
public class HotelSqlProvider {

    public String count(){ return "SELECT count(*) FROM t_cms_hotel WHERE DELETE_STATUS=0 AND STATE=1"; }

    public String count2(){ return "SELECT count(*) FROM t_cms_hotel WHERE DELETE_STATUS=0 "; }

    public String findById() {
        return "SELECT * FROM t_cms_hotel WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    public String findList(){
        return "SELECT * FROM t_cms_hotel WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String indexList(){
        return "SELECT * FROM t_cms_hotel WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }

    public String findListByQuery(){
        return "SELECT * FROM t_cms_hotel WHERE DELETE_STATUS=0 AND HOTEL_NAME LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String update(){
        return "UPDATE t_cms_hotel SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),HOTEL_NAME=#{hotelName}, " +
                "HOTEL_INTRO=#{hotelIntro},HOTEL_STAR=#{hotelStar},LINK_PHONE=#{linkPhone},ADDRESS=#{address},STATE=#{state},IMG_URL=#{imgUrl}," +
                "PRICE=#{price} WHERE id=#{id}";
    }

    public String save(){
        return "INSERT INTO t_cms_hotel(ID,ADD_USER_ID,ADD_TIME,HOTEL_NAME,HOTEL_INTRO,HOTEL_STAR,LINK_PHONE,ADDRESS,STATE, IMG_URL,PRICE) " +
                "VALUES(#{id},#{addUserId},NOW(),#{hotelName},#{hotelIntro},#{hotelStar},#{linkPhone},#{address},#{state},#{imgUrl},#{price})";
    }

    public String deleteByid(){
        return "UPDATE t_cms_hotel SET DELETE_STATUS=1 WHERE id=#{id}";
    }


    public String state0count(){ return "SELECT count(*) FROM t_cms_hotel WHERE DELETE_STATUS=0 AND STATE=0"; }
    public String state1count(){ return "SELECT count(*) FROM t_cms_hotel WHERE DELETE_STATUS=0 AND STATE=1"; }
    public String state2count(){ return "SELECT count(*) FROM t_cms_hotel WHERE DELETE_STATUS=0 AND STATE=2"; }

}
