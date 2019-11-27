package com.cn.travel.cms.scenicSpot.entity;

import com.cn.travel.base.entity.BaseDomain;

@SuppressWarnings("serial")
public class ScenicSpot extends BaseDomain {

    private String spotName;

    private String spotIntro;

    private Integer spotStar;

    private String spotAddress;

    private String openTime;

    private double ticketsMessage;

    private Integer state;

    private String imgUrl;

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotIntro() {
        return spotIntro;
    }

    public void setSpotIntro(String spotIntro) {
        this.spotIntro = spotIntro;
    }

    public Integer getSpotStar() {
        return spotStar;
    }

    public void setSpotStar(Integer spotStar) {
        this.spotStar = spotStar;
    }

    public String getSpotAddress() {
        return spotAddress;
    }

    public void setSpotAddress(String spotAddress) {
        this.spotAddress = spotAddress;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public double getTicketsMessage() {
        return ticketsMessage;
    }

    public void setTicketsMessage(double ticketsMessage) {
        this.ticketsMessage = ticketsMessage;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
