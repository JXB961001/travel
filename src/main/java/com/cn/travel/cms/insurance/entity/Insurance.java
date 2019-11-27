package com.cn.travel.cms.insurance.entity;

import com.cn.travel.base.entity.BaseDomain;
@SuppressWarnings("serial")
public class Insurance extends BaseDomain{

    private String title;

    private Integer insuranceCompany;

    private double price;

    private Integer type;

    private String resume;

    private Integer state;

    private String imgUrl;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInsuranceCompany(Integer insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public Integer getInsuranceCompany() {
        return insuranceCompany;
    }

    public double getPrice() {
        return price;
    }

    public Integer getType() {
        return type;
    }

    public String getResume() {
        return resume;
    }

    public Integer getState() {
        return state;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
