package com.cn.travel.role.user.entity;

import com.cn.travel.base.entity.BaseDomain;

@SuppressWarnings("serial")
public class Porvice extends BaseDomain {

    private Long province;

    private String count;

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
