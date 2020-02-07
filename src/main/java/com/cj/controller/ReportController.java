package com.cj.controller;

import com.cj.dto.echarts.Option;
import com.cj.entity.Reports;
import com.cj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/reports")
@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    @RequestMapping
    public String index() {
        return "report/orderReport";
    }

    @ResponseBody
    @RequestMapping("/getParam")
    public Option report() {
        List<Reports> reportsList = reportService.QueryCount();
        return reportService.Package(reportsList);
    }
}
