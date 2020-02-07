package com.cj.dto;

import java.util.List;

public class CommentListDto {
    private boolean hasMore;
    private List<CommentDto> data;

    public CommentListDto() {
    }

    @Override
    public String toString() {
        return "CommentListDto{" +
                "hasMore=" + hasMore +
                ", data=" + data +
                '}';
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<CommentDto> getData() {
        return data;
    }

    public void setData(List<CommentDto> data) {
        this.data = data;
    }
}
