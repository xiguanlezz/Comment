package com.cj.service;

import com.cj.dao.MenuDao;
import com.cj.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    public List<Menu> QueryAll() {
        return menuDao.QueryAll();
    }
}
