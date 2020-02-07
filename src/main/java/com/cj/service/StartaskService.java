package com.cj.service;

import com.cj.dao.StartaskDao;
import com.cj.entity.Startask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StartaskService {

    @Autowired
    private StartaskDao startaskDao;

    public boolean Add(String currentTime) {
        if (startaskDao.Add(currentTime) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean Update(String currentTime) {
        if (startaskDao.Update(currentTime) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
