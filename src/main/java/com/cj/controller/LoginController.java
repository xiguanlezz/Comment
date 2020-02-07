package com.cj.controller;

import com.cj.dto.AdminDto;
import com.cj.entity.Admins;
import com.cj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    @RequestMapping
    public String index() {
        return "system/login";
    }

    //    @ResponseBody
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public void validate(@Valid AdminDto a, HttpSession session, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
//        System.out.println(a);
        if (adminService.isPassed(a)) {
            AdminDto admin = adminService.QueryByUsername(a.getAdminUsername());
            session.setAttribute("admin", admin);
//            return "登录成功";
            out.print("登录成功");
        } else {
//            return "登录失败";
            out.print("登录失败");
        }

    }
}
