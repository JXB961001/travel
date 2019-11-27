package com.cn.travel.role.admin.provider;

import org.springframework.stereotype.Component;

@Component
public class AdminSqlProvider {

    public String login() {
        return "SELECT * FROM t_pz_admin_user WHERE USER_NAME = #{userName} AND PASSWORD = #{password} AND DELETE_STATUS = 0";
    }

    public String findByUserName() {
        return "SELECT * FROM t_pz_admin_user WHERE USER_NAME = #{userName} AND DELETE_STATUS = 0";
    }

    public String count(){ return "SELECT count(*) FROM t_pz_admin_user WHERE DELETE_STATUS=0"; }

    public String findById() {
        return "SELECT * FROM t_pz_admin_user WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    public String findList(){
        return "SELECT * FROM t_pz_admin_user WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String findListByQuery(){
        return "SELECT * FROM t_pz_admin_user WHERE DELETE_STATUS=0 AND USER_NAME LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String update(){
        return "UPDATE t_pz_admin_user SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),USER_NAME=#{userName}," +
                " PASSWORD=#{password},LINK_TEL=#{linkTel},NAME=#{name},STATE=#{state} WHERE id=#{id}";
    }

    public String save(){
        return "INSERT INTO t_pz_admin_user(ID,ADD_USER_ID,ADD_TIME,USER_NAME,PASSWORD,LINK_TEL,NAME,STATE) VALUES" +
                "(#{id},#{addUserId},NOW(),#{userName},#{password},#{linkTel},#{name},#{state})";
    }

    public String deleteByid(){
        return "UPDATE t_pz_admin_user SET DELETE_STATUS=1 WHERE id=#{id}";
    }
}
