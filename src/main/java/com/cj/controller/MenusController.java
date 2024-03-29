package com.cj.controller;

import com.cj.dao.MenuDao;
import com.cj.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenusController {

    @Autowired
    private MenuDao menuDao;

    @ResponseBody
    @RequestMapping("/menus")
    public List<Menu> show() {
        List<Menu> menus = menuDao.QueryAll();
//        System.out.println(menus);
        return menus;
    }
}
