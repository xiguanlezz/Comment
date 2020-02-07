package com.cj.dao;

import com.cj.entity.Admins;

public interface AdminsDao {
    public int Add(Admins admins);

    public int Update(Admins admins);

    public Admins Query(Admins admin);

    public Admins QueryByUsername(String username);

    public String QueryPwdById(Integer id);
}
