package com.cj.entity;

/**
 * 这个类是指简单的封装个对象, 并没有数据库中的表和该类对应
 */
public class Reports {
    private Integer reportId;
    private String reportCate;
    private Integer reportHour;
    private Integer reportCount;

    public Reports() {
    }

    @Override
    public String toString() {
        return "Reports{" +
                "reportId=" + reportId +
                ", reportCate='" + reportCate + '\'' +
                ", reportHour=" + reportHour +
                ", reportCount=" + reportCount +
                '}';
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportCate() {
        return reportCate;
    }

    public void setReportCate(String reportCate) {
        this.reportCate = reportCate;
    }

    public Integer getReportHour() {
        return reportHour;
    }

    public void setReportHour(Integer reportHour) {
        this.reportHour = reportHour;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }
}
