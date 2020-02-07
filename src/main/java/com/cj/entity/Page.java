package com.cj.entity;


public class Page {
    private Integer currentPage;
    private Integer totalPage;
    private Integer pageSize;
    private Integer totalCount;

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                '}';
    }

    public Page() {
        this.currentPage = 1;
        this.pageSize = 10;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        //计算总页数
        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);
    }
}
