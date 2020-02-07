package com.cj.service;

import com.cj.dao.DicDao;
import com.cj.entity.Dic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicService {
    @Autowired
    private DicDao dicDao;

    public List<Dic> QueryByType(String type) {
        return dicDao.QueryByType(type);
    }
}
