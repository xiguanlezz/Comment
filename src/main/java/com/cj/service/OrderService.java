package com.cj.service;

import com.cj.constant.OrderStateConst;
import com.cj.dao.OrderDao;
import com.cj.dto.OrderDto;
import com.cj.entity.Orders;
import com.cj.util.CommonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Value("${business.url}")
    private String imgURL;

    public boolean Add(OrderDto o) {
        Orders orders = new Orders();
//        orders.setOrderBId(o.getOrderBId());
//        orders.setOrderMId(o.getOrderMId());
//        orders.setOrderNumber(o.getOrderNumber());
        BeanUtils.copyProperties(o, orders);
        orders.setOrderState(OrderStateConst.NOTEVALUATED);
//        orders.setOrderTime(CommonUtil.getcurrentTime("yyyy-MM-dd HH:mm:ss"));
        if (orderDao.Add(orders) > 0) {
            return true;
        } else {
            System.out.println("失败");
            return false;
        }
    }

    public boolean UpdateState(Integer id) {
        return orderDao.UpdateState(id) > 0 ? true : false;
    }

    public Integer QueryMIdById(Integer id) {
        return orderDao.QueryMIdById(id);
    }

    public List<OrderDto> QueryByMId(Integer id) {
        List<Orders> ordersList = orderDao.QueryByMId(id);
        List<OrderDto> orderDtos = new ArrayList<OrderDto>();
        for (Orders o : ordersList) {
            OrderDto orderDto = new OrderDto();
            orderDto.setId(o.getOrderId());
            orderDto.setImg(imgURL + o.getOrderBusiness().getBusinessImgName());
            orderDto.setTitle(o.getOrderBusiness().getBusinessTitle());
            orderDto.setCount(o.getOrderNumber());
            orderDto.setCommentState(o.getOrderState());
            orderDto.setPrice(o.getOrderPrice());
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    public List<OrderDto> QueryAll() {
        List<OrderDto> result = new ArrayList<OrderDto>();
        List<Orders> ordersList = orderDao.QueryAll();
        for (Orders o : ordersList) {
            OrderDto t = new OrderDto();
            BeanUtils.copyProperties(o, t);
            result.add(t);
        }
        return result;
    }

    public List<OrderDto> QueryByPage(OrderDto orderDto) {
        List<OrderDto> result = new ArrayList<OrderDto>();
        Orders orders = new Orders();
        BeanUtils.copyProperties(orderDto, orders);
        List<Orders> ordersList = orderDao.QueryByPage(orders);
        for (Orders o : ordersList) {
            OrderDto t = new OrderDto();
            BeanUtils.copyProperties(o, t);
            result.add(t);
        }
        return result;
    }
}
