package com.cj.entity;

public class BaseBean {
//    private String id;
    Page page;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public BaseBean() {
        this.page = new Page();
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
