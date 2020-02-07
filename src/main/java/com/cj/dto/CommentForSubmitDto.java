package com.cj.dto;

public class CommentForSubmitDto {
    private Integer id;    //订单id
    private String comment;
    private Integer star;
    private String token;
    private Long username;  //手机号

    @Override
    public String toString() {
        return "CommentForSubmitDto{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", star=" + star +
                ", token='" + token + '\'' +
                ", username=" + username +
                '}';
    }

    public CommentForSubmitDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }
}
