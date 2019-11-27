package com.cn.travel.cms.order.provider;

import org.springframework.stereotype.Component;

@Component
public class OrderSqlProvider {

    public String findById() {
        return "SELECT * FROM t_yw_order WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    public String count(){ return "SELECT count(*) FROM t_yw_order WHERE DELETE_STATUS=0"; }

    public String countByUserId(){ return "SELECT count(*) FROM t_yw_order WHERE USER_ID=#{userId} AND DELETE_STATUS=0"; }

    public String findList(){
        return "SELECT * FROM t_yw_order WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String findListByQuery(){
        return "SELECT * FROM t_yw_order WHERE DELETE_STATUS=0 AND USER_NAME LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String findListByUserId(){
        return "SELECT * FROM t_yw_order WHERE USER_ID=#{userId} AND DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String update(){
        return "UPDATE t_yw_order SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),USER_ID=#{userId},USER_NAME=#{userName}," +
                " PRODUCT_ID=#{productId},PRODUCT_NAME=#{productName},FEE=#{fee},PRODUCT_TYPE=#{productType},STATE=#{state}," +
                "ORDER_CODE=#{orderCode},ORDER_TIME=#{orderTime},SETOFF_TIME=#{setoffTime},LINK_TEL=#{linkTel},PEOPLE_COUNT=#{peopleCount}" +
                ",REQUIREMENT=#{requirement},IC_CODE=#{icCode},IMG_URL=#{imgUrl} WHERE id=#{id}";
    }

    public String save(){
        return "INSERT INTO t_yw_order(ID,ADD_USER_ID,ADD_TIME,USER_ID,USER_NAME,PRODUCT_ID,PRODUCT_NAME,FEE,PRODUCT_TYPE,STATE,ORDER_CODE,ORDER_TIME," +
                "SETOFF_TIME,LINK_TEL,PEOPLE_COUNT,REQUIREMENT,IC_CODE,IMG_URL) VALUES(#{id},#{addUserId},NOW(),#{userId},#{userName},#{productId},#{productName}," +
                "#{fee},#{productType},#{state},#{orderCode},#{orderTime},#{setoffTime},#{linkTel},#{peopleCount},#{requirement},#{icCode},#{imgUrl})";
    }

    public String deleteByid(){
        return "UPDATE t_yw_order SET DELETE_STATUS=1 WHERE id=#{id}";
    }


    public String state0count(){ return "SELECT count(*) FROM t_yw_order WHERE DELETE_STATUS=0 AND PRODUCT_TYPE=0"; }
    public String state1count(){ return "SELECT count(*) FROM t_yw_order WHERE DELETE_STATUS=0 AND PRODUCT_TYPE=1"; }
    public String state2count(){ return "SELECT count(*) FROM t_yw_order WHERE DELETE_STATUS=0 AND PRODUCT_TYPE=2"; }
}
