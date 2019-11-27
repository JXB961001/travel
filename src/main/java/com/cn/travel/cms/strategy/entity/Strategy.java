package com.cn.travel.cms.strategy.entity;

import com.cn.travel.base.entity.BaseDomain;
@SuppressWarnings("serial")
public class Strategy extends BaseDomain {
    private String imgUrl;

    private String title;

    private Integer rating;

    private String summary;

    private String introUrl;

    private Integer state;

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRating() {
        return rating;
    }

    public String getSummary() {
        return summary;
    }

    public String getIntroUrl() {
        return introUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIntroUrl(String introUrl) {
        this.introUrl = introUrl;
    }

}
