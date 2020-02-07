package com.cj.dao;

import com.cj.entity.Member;

public interface MemberDao {
    public Member QueryByPhone(Long phone);

    public Integer QueryIdByPhone(Long phone);
}
