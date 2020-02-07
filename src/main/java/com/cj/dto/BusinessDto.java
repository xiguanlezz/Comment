package com.cj.dto;

import com.cj.entity.Business;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.omg.CORBA.PRIVATE_MEMBER;

//写接口传json的时候, null的值不参与序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessDto extends Business {
    private String id;
    private String img;
    private String title;
    private String subTitle;
    private String distance;
//    private Integer id;
    private Integer mumber;
    private Integer star;
    private Integer price;
    private String desc;
    private String keyword;

    public BusinessDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Integer getMumber() {
        return mumber;
    }

    public void setMumber(Integer mumber) {
        this.mumber = mumber;
    }
}
