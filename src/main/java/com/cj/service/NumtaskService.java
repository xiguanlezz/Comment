package com.cj.service;

import com.cj.dao.NumtaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class NumtaskService {
    @Autowired
    private NumtaskDao numtaskDao;

    public boolean Add(String currentTime) {
        if (numtaskDao.Add(currentTime) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean Update(String currentTime) {
        if (numtaskDao.Update(currentTime) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
