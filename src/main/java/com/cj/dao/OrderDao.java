package com.cj.dao;

import com.cj.entity.Orders;

import java.util.List;

public interface OrderDao {
    public int Add(Orders order);

    public int UpdateState(Integer id);

    public Integer QueryMIdById(Integer id);

    public List<Orders> QueryByMId(Integer id);

    public List<Orders> QueryAll();

    public List<Orders> QueryByPage(Orders orders);
}
