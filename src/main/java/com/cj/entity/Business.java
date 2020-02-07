package com.cj.entity;

import javax.validation.constraints.NotBlank;

public class Business extends BaseBean{
    private Integer businessId;
    private String businessImgName;
    @NotBlank(message = "主标题不能为空！")
    private String businessTitle;
    private String businessSubtitle;
    private Integer businessPrice;
    private Integer businessDistance;
    private Integer businessNumber;
    private Integer businessStar;
    private String businessDesc;
    private Integer businessRedundancyTotalNumber;
    private Integer businessRedundancyTotalScore;
    @NotBlank(message = "城市不能为空！")
    private String businessCityCode;
    @NotBlank(message = "类别不能为空！")
    private String businessCateCode;

    private Dic cityDic;
    private Dic cateDic;

    public Integer getBusinessRedundancyTotalNumber() {
        return businessRedundancyTotalNumber;
    }

    public void setBusinessRedundancyTotalNumber(Integer businessRedundancyTotalNumber) {
        this.businessRedundancyTotalNumber = businessRedundancyTotalNumber;
    }

    public Integer getBusinessRedundancyTotalScore() {
        return businessRedundancyTotalScore;
    }

    public void setBusinessRedundancyTotalScore(Integer businessRedundancyTotalScore) {
        this.businessRedundancyTotalScore = businessRedundancyTotalScore;
    }

    public Dic getCityDic() {
        return cityDic;
    }

    public void setCityDic(Dic cityDic) {
        this.cityDic = cityDic;
    }

    public Dic getCateDic() {
        return cateDic;
    }

    public void setCateDic(Dic cateDic) {
        this.cateDic = cateDic;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", businessImgName='" + businessImgName + '\'' +
                ", businessTitle='" + businessTitle + '\'' +
                ", businessSubtitle='" + businessSubtitle + '\'' +
                ", businessPrice=" + businessPrice +
                ", businessDistance=" + businessDistance +
                ", businessNumber=" + businessNumber +
                ", businessStar=" + businessStar +
                ", businessDesc='" + businessDesc + '\'' +
                ", businessRedundancyTotalNumber=" + businessRedundancyTotalNumber +
                ", businessRedundancyTotalScore=" + businessRedundancyTotalScore +
                ", businessCityCode='" + businessCityCode + '\'' +
                ", businessCateCode='" + businessCateCode + '\'' +
                ", cityDic=" + cityDic +
                ", cateDic=" + cateDic +
                "} " + super.toString();
    }

    public Business() {
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessImgName() {
        return businessImgName;
    }

    public void setBusinessImgName(String businessImgName) {
        this.businessImgName = businessImgName;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public String getBusinessSubtitle() {
        return businessSubtitle;
    }

    public void setBusinessSubtitle(String businessSubtitle) {
        this.businessSubtitle = businessSubtitle;
    }

    public Integer getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(Integer businessPrice) {
        this.businessPrice = businessPrice;
    }

    public Integer getBusinessDistance() {
        return businessDistance;
    }

    public void setBusinessDistance(Integer businessDistance) {
        this.businessDistance = businessDistance;
    }

    public Integer getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(Integer businessNumber) {
        this.businessNumber = businessNumber;
    }

    public Integer getBusinessStar() {
        return businessStar;
    }

    public void setBusinessStar(Integer businessStar) {
        this.businessStar = businessStar;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }

    public String getBusinessCityCode() {
        return businessCityCode;
    }

    public void setBusinessCityCode(String businessCityCode) {
        this.businessCityCode = businessCityCode;
    }

    public String getBusinessCateCode() {
        return businessCateCode;
    }

    public void setBusinessCateCode(String businessCateCode) {
        this.businessCateCode = businessCateCode;
    }
}
