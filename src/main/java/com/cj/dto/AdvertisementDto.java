package com.cj.dto;

import com.cj.entity.Advertisement;
import com.fasterxml.jackson.annotation.JsonInclude;

//写接口传json的时候, null的值不参与序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvertisementDto extends Advertisement implements Comparable<AdvertisementDto> {
    private String title;
    private String img;
    private String link;

    public String getTitle() {
        return title;
    }

    public AdvertisementDto() {
    }

    @Override
    public int compareTo(AdvertisementDto o) {
        //按权重递减顺序排序, 权重大就显示在前面
        return o.getAdvertisementWeight() - this.getAdvertisementWeight();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
