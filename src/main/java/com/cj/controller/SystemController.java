package com.cj.controller;

import com.cj.dto.AdminDto;
import com.cj.dto.echarts.Option;
import com.cj.entity.Reports;
import com.cj.service.AdminService;
import com.cj.service.ReportService;
import com.cj.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/system")
@Controller
public class SystemController {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping("/getTime")
    public String getTime() {
        String currentTime = CommonUtil.getcurrentTime("yyyy-MM-dd HH:mm:ss");
        return currentTime;
    }

    @ResponseBody
    @RequestMapping("/check")
    public String CheckOldPwd(@RequestParam("adminId") Integer id, @RequestParam("oldPwd") String oldPwd) {
        System.out.println(oldPwd);
        if (adminService.isTrue(oldPwd, id)) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping("/update")
    public String updatePwd(Model model, @RequestParam("newPasswordAgainMD5") String newPwd, @RequestParam("adminId") Integer id) {
        AdminDto admins = new AdminDto();
        admins.setAdminId(id);
        admins.setAdminPassword(newPwd);
        System.out.println(admins);
        adminService.Update(admins);
        model.addAttribute("msg", "密码修改成功, 请重新登录");
        return "system/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        //使整个session失效, 而removeAttribute仅仅是移除某个属性
        request.getSession().invalidate();
        return "system/login";
    }

}
