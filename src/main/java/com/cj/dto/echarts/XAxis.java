package com.cj.dto.echarts;

import java.util.List;

public class XAxis {
    List<String> data;

    @Override
    public String toString() {
        return "XAxis{" +
                "data=" + data +
                '}';
    }

    public XAxis() {
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
