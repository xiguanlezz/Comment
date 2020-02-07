package com.cj.dao;

import com.cj.entity.Dic;

import java.util.List;

public interface DicDao {
    public List<Dic> QueryByType(String type);
}
