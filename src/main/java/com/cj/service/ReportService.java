package com.cj.service;

import com.cj.dao.ReportDao;
import com.cj.dto.echarts.Legend;
import com.cj.dto.echarts.Option;
import com.cj.dto.echarts.Series;
import com.cj.dto.echarts.XAxis;
import com.cj.entity.Reports;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {
    @Autowired
    private ReportDao reportDao;

    public List<Reports> QueryCount() {
        List<Map<String, Object>> maps = reportDao.QueryCount();
        List<Reports> reports = new ArrayList<Reports>();
        for (Map<String, Object> map : maps) {
//            System.out.println(map);
            Reports r = new Reports();
//            r.setReportHour(map.);
            Set<String> set = map.keySet();
            int i = 0;
            for (String s : set) {
                if (i == 0) {
                    r.setReportHour(Integer.parseInt((String) map.get(s)));
                } else if (i == 1) {
                    r.setReportCate((String) map.get(s));
                } else if (i == 2) {
                    r.setReportCount(Integer.parseInt((String) map.get(s)));
                }
                i++;
            }
            reports.add(r);
        }
        return reports;
    }

    public Option Package(List<Reports> reports) {
        Option result = new Option();
        List<Series> series = new ArrayList<Series>();
        Legend legend = new Legend();
        Set<String> legendData = new LinkedHashSet<String>();
        List<String> xAxisData = new ArrayList<String>();

        //name+hour唯一确定数字
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();

        //设置legend
        for (Reports r : reports) {
            map.put(r.getReportCate() + r.getReportHour(), r.getReportCount());
            legendData.add(r.getReportCate());
        }
        legend.setData(legendData);
        result.setLegend(legend);

        //设置横坐标的刻度
        for (Integer i = 0; i < 24; i += 2) {
            String temp = i.toString();
            xAxisData.add(String.format("%02d", i));
        }
        XAxis xAxis = new XAxis();
        xAxis.setData(xAxisData);
        result.setxAxis(xAxis);

        //设置Series
        for (String name : legendData) {
            Series serie = new Series();
            List<Integer> seriesData = new ArrayList<Integer>();
            for (String s : xAxisData) {
                int t = map.get(name + s) == null ? 0 : map.get(name + s);
                seriesData.add(t);
            }
            serie.setName(name);
            serie.setType("line");
            serie.setData(seriesData);
            series.add(serie);
        }
        result.setSeries(series);

        return result;
    }
}
