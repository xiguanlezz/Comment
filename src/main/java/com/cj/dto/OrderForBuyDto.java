package com.cj.dto;

public class OrderForBuyDto {
    private Integer id;        // 商户id
    private String token;
    private Integer num;    //默认是1
    private Integer price;
    private Long username;

    public OrderForBuyDto() {
    }

    @Override
    public String toString() {
        return "OrderForBuyDto{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", username=" + username +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }
}
