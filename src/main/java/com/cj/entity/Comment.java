package com.cj.entity;

public class Comment extends BaseBean{
    private Integer commentId;
    private Integer commentOId;
    private Integer commentMId;
    private Integer commentStar;
    private String commentContent;
    private String commentTime;
    private Orders commentOrder;
    private Member commentMember;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentOId=" + commentOId +
                ", commentMId=" + commentMId +
                ", commentStar=" + commentStar +
                ", commentContent='" + commentContent + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", commentOrder=" + commentOrder +
                ", commentMember=" + commentMember +
                "} " + super.toString();
    }

    public Comment() {
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentOId() {
        return commentOId;
    }

    public void setCommentOId(Integer commentOId) {
        this.commentOId = commentOId;
    }

    public Integer getCommentMId() {
        return commentMId;
    }

    public void setCommentMId(Integer commentMId) {
        this.commentMId = commentMId;
    }

    public Integer getCommentStar() {
        return commentStar;
    }

    public void setCommentStar(Integer commentStar) {
        this.commentStar = commentStar;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public Orders getCommentOrder() {
        return commentOrder;
    }

    public void setCommentOrder(Orders commentOrder) {
        this.commentOrder = commentOrder;
    }

    public Member getCommentMember() {
        return commentMember;
    }

    public void setCommentMember(Member commentMember) {
        this.commentMember = commentMember;
    }
}
