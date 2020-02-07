package com.cj.controller;

import com.cj.dto.OrderDto;
import com.cj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/orders")
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping
    public String show(Model model, OrderDto o) {
        System.out.println(o);
        List<OrderDto> orderDtoList = orderService.QueryByPage(o);
        model.addAttribute("orders", orderDtoList);
        model.addAttribute("searchod", o);

        Map<Integer, Long> map = new LinkedHashMap<Integer, Long>();
        for (OrderDto orderDto : orderDtoList) {
            map.put(orderDto.getOrderId(), orderDto.getOrderMember().getMemberPhone());
        }
        model.addAttribute("Id_PhoneMap", map);
        return "content/orderList";
    }

    @RequestMapping("/search")
    public String search(Model model, OrderDto o) {
        System.out.println(o);
        List<OrderDto> orderDtoList = orderService.QueryByPage(o);
        model.addAttribute("orders", orderDtoList);
        model.addAttribute("searchod", o);

        //前端不怎么会操作json, 只能后台封装map回显给jsp页面
        Map<Integer, Long> map = new LinkedHashMap<Integer, Long>();
        for (OrderDto orderDto : orderDtoList) {
            map.put(orderDto.getOrderId(), orderDto.getOrderMember().getMemberPhone());
        }
        model.addAttribute("Id_PhoneMap", map);
        return "content/orderList";
    }
}
