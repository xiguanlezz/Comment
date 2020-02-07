package com.cj.entity;

public class Member {
    private Integer memberId;
    private Long memberPhone;
    private String memberUsername;
    private String memberPassword;

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberPhone=" + memberPhone +
                ", memberUsername='" + memberUsername + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                '}';
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Long getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(Long memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
}
