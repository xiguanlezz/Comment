package com.cj.dto.echarts;

import java.util.List;

public class Option {
    private Legend legend;
    private List<Series> series;
    private XAxis xAxis;

    @Override
    public String toString() {
        return "Option{" +
                "legend=" + legend +
                ", series=" + series +
                ", xAxis=" + xAxis +
                '}';
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public Option() {
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}
