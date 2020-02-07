package com.cj.service;

import com.cj.dao.AdminsDao;
import com.cj.dto.AdminDto;
import com.cj.entity.Admins;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;


@Service
public class AdminService {
    @Autowired
    private AdminsDao adminsDao;

    public boolean Add(AdminDto adminDto) {
        Admins admins = new Admins();
        BeanUtils.copyProperties(adminDto, admins);
        return adminsDao.Add(admins) > 0 ? true : false;
    }

    public boolean Update(AdminDto adminDto) {
        Admins admins = new Admins();
        BeanUtils.copyProperties(adminDto, admins);
        return adminsDao.Update(admins) > 0 ? true : false;
    }

    public AdminDto QueryByUsername(String username) {
        AdminDto adminDto = new AdminDto();
        Admins admins = adminsDao.QueryByUsername(username);
        BeanUtils.copyProperties(admins, adminDto);
        return adminDto;
    }

    public boolean isPassed(AdminDto adminDto) {
        Admins admins = new Admins();
        BeanUtils.copyProperties(adminDto, admins);

        Admins a = adminsDao.Query(admins);
        if (a != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTrue(String oldPwd,Integer id) {
        String pwd=adminsDao.QueryPwdById(id);
        System.out.println(pwd);
        if(pwd!=null&&pwd.equals(oldPwd)) {
            return true;
        } else {
            return false;
        }
    }
}
