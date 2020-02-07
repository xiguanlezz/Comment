package com.cj.dao;

import com.cj.entity.Advertisement;
import com.cj.entity.Page;

import java.util.List;
import java.util.Map;

public interface AdvertisementDao {
    public int Add(Advertisement a);

    public int AddBatch(List<Advertisement> ads);

    public int Delete(Integer id);

    public int Update(Advertisement a);

    public Advertisement QueryById(Integer id);

    public List<Advertisement> QueryAll();

    public List<Advertisement> QueryByPage(Advertisement a);

    public Integer QueryTotalCount();
}
