package com.cj.entity;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Advertisement extends BaseBean{
    private Integer advertisementId;
    @NotBlank(message = "广告标题不能为空！")
    private String advertisementName;
//    @Pattern(regexp = ".png$", message = "只支持JPG和PNG格式的文件")
//    @NotBlank(message = "图片不能为空！")
    private String advertisementImgName;
    @NotBlank(message = "链接地址不能为空！")
    private String advertisementLink;
    @Range(message = "权重最多包含5位整数！", min = 1, max = 99999)
    private Integer advertisementWeight;

    @Override
    public String toString() {
        return "Advertisement{" +
                "advertisementId=" + advertisementId +
                ", advertisementName='" + advertisementName + '\'' +
                ", advertisementImgName='" + advertisementImgName + '\'' +
                ", advertisementLink='" + advertisementLink + '\'' +
                ", advertisementWeight=" + advertisementWeight +
                ", page=" + page +
                "} " + super.toString();
    }

    public Advertisement(Integer advertisementId, String advertisementName, String advertisementImgName, String advertisementLink, Integer advertisementWeight) {
        this.advertisementId = advertisementId;
        this.advertisementName = advertisementName;
        this.advertisementImgName = advertisementImgName;
        this.advertisementLink = advertisementLink;
        this.advertisementWeight = advertisementWeight;
    }

    public Advertisement() {
    }

    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdvertisementName() {
        return advertisementName;
    }

    public void setAdvertisementName(String advertisementName) {
        this.advertisementName = advertisementName;
    }

    public String getAdvertisementImgName() {
        return advertisementImgName;
    }

    public void setAdvertisementImgName(String advertisementImgName) {
        this.advertisementImgName = advertisementImgName;
    }

    public String getAdvertisementLink() {
        return advertisementLink;
    }

    public void setAdvertisementLink(String advertisementLink) {
        this.advertisementLink = advertisementLink;
    }

    public Integer getAdvertisementWeight() {
        return advertisementWeight;
    }

    public void setAdvertisementWeight(Integer advertisementWeight) {
        this.advertisementWeight = advertisementWeight;
    }
}
