package com.cj.task;

import com.cj.service.BusinessService;
import com.cj.service.NumtaskService;
import com.cj.service.StartaskService;
import com.cj.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("BusinessTask")
public class BusinessTask {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private NumtaskService numtaskService;
    @Autowired
    private StartaskService startaskService;

    public void synNumber() {
        businessService.newUpdateNumber();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        numtaskService.Update(CommonUtil.getcurrentTime("yyyy-MM:dd HH:mm:ss"));
        System.out.println("商户已售数量同步完成");
    }

    public void synStar() {
        businessService.newUpdateStar();
        //        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        startaskService.Update(CommonUtil.getcurrentTime("yyyy-MM:dd HH:mm:ss"));
        System.out.println("商户评分同步完成");
    }
}
