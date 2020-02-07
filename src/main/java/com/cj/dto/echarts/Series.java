package com.cj.dto.echarts;

import java.util.List;
import java.util.Objects;

public class Series {
    private String name;
    private String type;
    private List<Integer> data;

    public Series() {
    }

    @Override
    public String toString() {
        return "Series{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return Objects.equals(name, series.name) &&
                Objects.equals(type, series.type) &&
                Objects.equals(data, series.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, data);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
