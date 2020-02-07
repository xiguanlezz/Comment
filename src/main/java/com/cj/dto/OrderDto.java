package com.cj.dto;

import com.cj.entity.Orders;

public class OrderDto extends Orders {
    private Integer id;
    private String img;
    private String title;
    private Integer count;
    private Integer price;
    private Integer commentState;

    public OrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCommentState() {
        return commentState;
    }

    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", commentState=" + commentState +
                "} " + super.toString();
    }
}
