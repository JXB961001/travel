package com.cn.travel.cms.insurance.provider;

import org.springframework.stereotype.Component;

@Component
public class InsuranceSqlProvider {
    public String count(){ return "SELECT count(*) FROM t_cms_insurance WHERE DELETE_STATUS=0 "; }



    public String findById() {
        return "SELECT * FROM t_cms_insurance WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    public String findList(){
        return "SELECT * FROM t_cms_insurance WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String indexList(){
        return "SELECT * FROM t_cms_insurance WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }

    public String findListByQuery(){
        return "SELECT * FROM t_cms_insurance WHERE DELETE_STATUS=0 AND TITLE LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String update(){
        return "UPDATE t_cms_insurance SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),TITLE=#{title}, " +
                "INSURANCE_COMPANY=#{insuranceCompany},PRICE=#{price},TYPE=#{type},RESUME=#{resume},STATE=#{state},IMG_URL=#{imgUrl}" +
                " WHERE id=#{id}";
    }

    public String save(){
        return "INSERT INTO t_cms_insurance(ID,ADD_USER_ID,ADD_TIME,TITLE,INSURANCE_COMPANY,PRICE,TYPE,RESUME,STATE, IMG_URL) " +
                "VALUES(#{id},#{addUserId},NOW(),#{title},#{insuranceCompany},#{price},#{type},#{resume},#{state},#{imgUrl})";
    }

    public String deleteByid(){
        return "UPDATE t_cms_insurance SET DELETE_STATUS=1 WHERE id=#{id}";
    }


    public String state0count(){ return "SELECT count(*) FROM t_cms_insurance WHERE DELETE_STATUS=0 AND STATE=0"; }
    public String state1count(){ return "SELECT count(*) FROM t_cms_insurance WHERE DELETE_STATUS=0 AND STATE=1"; }
    public String state2count(){ return "SELECT count(*) FROM t_cms_insurance WHERE DELETE_STATUS=0 AND STATE=2"; }


    public String company0count(){ return "SELECT count(*) FROM t_cms_insurance WHERE DELETE_STATUS=0 AND INSURANCE_COMPANY=0"; }
    public String company1count(){ return "SELECT count(*) FROM t_cms_insurance WHERE DELETE_STATUS=0 AND INSURANCE_COMPANY=1"; }
}
