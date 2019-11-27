package com.cn.travel.cms.hotel.entity;

import com.cn.travel.base.entity.BaseDomain;

@SuppressWarnings("serial")
public class Hotel extends BaseDomain {

    private String hotelName;

    private String hotelIntro;

    private Integer hotelStar;

    private String linkPhone;

    private String address;

    private Integer state;

    private String imgUrl;

    private double price;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelIntro() {
        return hotelIntro;
    }

    public void setHotelIntro(String hotelIntro) {
        this.hotelIntro = hotelIntro;
    }

    public Integer getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(Integer hotelStar) {
        this.hotelStar = hotelStar;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {

        return price;
    }
}
