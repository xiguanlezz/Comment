package com.cj.dto.echarts;

import java.util.List;
import java.util.Set;

public class Legend {
    private Set<String> data;

    @Override
    public String toString() {
        return "Legend{" +
                "data=" + data +
                '}';
    }

    public Legend() {
    }

    public Set<String> getData() {
        return data;
    }

    public void setData(Set<String> data) {
        this.data = data;
    }
}
