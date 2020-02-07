package com.cj.entity;

public class Menu {
    private int menuId;
    private String menuName;
    private int menuPid;
    private String menuUrl;

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuPid=" + menuPid +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Menu(int menuId, String menuName, int menuPid, String menuUrl) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPid = menuPid;
        this.menuUrl = menuUrl;
    }

    public Menu() {
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(int menuPid) {
        this.menuPid = menuPid;
    }
}
