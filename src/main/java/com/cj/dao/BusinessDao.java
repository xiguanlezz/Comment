package com.cj.dao;

import com.cj.entity.Advertisement;
import com.cj.entity.Business;

import java.util.List;

public interface BusinessDao {
    public int Add(Business b);

    public int AddBatch(List<Business> bs);

    public int Delete(Integer id);

    public int Update(Business b);

    /**
     * 更新商户的已售数量
     * @return
     */
    public int UpdateNumber();

    /**
     * 通过在数据库中建立时间表来达到非全表查询的目的
     * 每次只查询订单创建时间在时间表中的数据后的, 并更新时间表中的数据
     * @return
     */
    public int newUpdateNumber();

    public int UpdateRedundancy();

    public int newUpdateStar();

    public Business QueryById(int id);

    public Business QueryById(Long id);

    public List<Business> QueryAll();

    /**
     * 多列模糊匹配要加小括号
     * @param b
     * @return
     */
    public List<Business> QueryByPage(Business b);

    public List<Business> QueryLikeByPage(Business b);
}
