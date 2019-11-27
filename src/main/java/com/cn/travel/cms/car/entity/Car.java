package com.cn.travel.cms.car.entity;

import com.cn.travel.base.entity.BaseDomain;
@SuppressWarnings("serial")
public class Car extends BaseDomain {

    private String title;

    private String startPlace;

    private String endPlace;

    private String startDateAndTime;

    private double needTime;

    private String gatherPlace;

    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    private Integer type;

    public double getPrice() {
        return price;
    }

    private String imgUrl;

    private Integer state;

    private String remark;

    public String getTitle() {
        return title;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public String getStartDateAndTime() {
        return startDateAndTime;
    }

    public double getNeedTime() {
        return needTime;
    }

    public String getGatherPlace() {
        return gatherPlace;
    }

    public Integer getType() {
        return type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public void setStartDateAndTime(String startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    public void setNeedTime(double needTime) {
        this.needTime = needTime;
    }

    public void setGatherPlace(String gatherPlace) {
        this.gatherPlace = gatherPlace;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }
}
