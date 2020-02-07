package com.cj.dto;

import com.cj.entity.Business;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessListDto {
    private boolean hasMore;
    private List<BusinessDto> data;

    @Override
    public String toString() {
        return "BusinessListDto{" +
                "hasMore=" + hasMore +
                ", data=" + data +
                '}';
    }

    public BusinessListDto() {
        this.data = new ArrayList<BusinessDto>();
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<BusinessDto> getData() {
        return data;
    }

    public void setData(List<BusinessDto> data) {
        this.data = data;
    }
}
