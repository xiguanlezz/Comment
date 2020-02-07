package com.cj.dto;

import com.cj.entity.Comment;

public class CommentDto extends Comment {
    private String username;
    private String comment;
    private Integer star;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "username=" + username +
                ", comment='" + comment + '\'' +
                ", star=" + star +
                "} " + super.toString();
    }

    public CommentDto() {
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
}
