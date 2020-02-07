package com.cj.entity;

import javax.validation.constraints.NotBlank;

public class Admins {
    private Integer adminId;
    @NotBlank(message = "用户名不能为空")
    private String adminUsername;
    @NotBlank(message = "密码不能为空")
    private String adminPassword;
    private String adminNickname;

    public Admins() {
    }

    @Override
    public String toString() {
        return "Admins{" +
                "adminId=" + adminId +
                ", adminUsername='" + adminUsername + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminNickname='" + adminNickname + '\'' +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminNickname() {
        return adminNickname;
    }

    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname;
    }
}
