package com.cj.entity;

public class Orders extends BaseBean{
    private Integer orderId;
    private Integer orderBId;
    private Integer orderMId;
    private Integer orderNumber;
    private Integer orderPrice;
    private Integer orderState;     //0-未评价 1-评价中 2-已评价
    private Business orderBusiness;
    private Member orderMember;
    private String orderTime;

    //为了后台管理界面订单管理的关键词(手机号)做模糊匹配准备的, 因为MySQL不支持数字的模糊匹配
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Business getOrderBusiness() {
        return orderBusiness;
    }

    public void setOrderBusiness(Business orderBusiness) {
        this.orderBusiness = orderBusiness;
    }

    public Member getOrderMember() {
        return orderMember;
    }

    public void setOrderMember(Member orderMember) {
        this.orderMember = orderMember;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderBId() {
        return orderBId;
    }

    public void setOrderBId(Integer orderBId) {
        this.orderBId = orderBId;
    }

    public Integer getOrderMId() {
        return orderMId;
    }

    public void setOrderMId(Integer orderMId) {
        this.orderMId = orderMId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderBId=" + orderBId +
                ", orderMId=" + orderMId +
                ", orderNumber=" + orderNumber +
                ", orderPrice=" + orderPrice +
                ", orderState=" + orderState +
                ", orderBusiness=" + orderBusiness +
                ", orderMember=" + orderMember +
                ", orderTime='" + orderTime + '\'' +
                ", keyword='" + keyword + '\'' +
                "} " + super.toString();
    }
}
