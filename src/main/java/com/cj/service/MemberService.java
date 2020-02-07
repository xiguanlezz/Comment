package com.cj.service;

import com.cj.cache.CodeCache;
import com.cj.cache.TokenCache;
import com.cj.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public boolean isExist(Long phone) {
        return memberDao.QueryByPhone(phone) == null ? false : true;
    }

    public boolean sendCode(Long phone, String code) {
//        codeCache.saveCode();
        System.out.println(phone + "---" + code);
        return true;
    }

    public boolean saveCode(Long phone, String codeAfterMD5) {
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.saveCode(phone, codeAfterMD5);
    }

    public boolean hasCode(Long phone) {
        CodeCache codeCache = CodeCache.getInstance();
        if (codeCache.getCode(phone) == null && "".equals(codeCache.getCode(phone).trim())) {
            return false;
        }
        return true;
    }

    public String getCode(Long phone) {
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.getCode(phone);
    }

    public void saveToken(Long phone, String token) {
        TokenCache tokenCache = TokenCache.getInstance();
        tokenCache.saveToken(token, phone);
    }

    public Long getPhone(String token) {
        TokenCache tokenCache = TokenCache.getInstance();
        return tokenCache.getPhone(token);
    }

    public Integer QueryIdByPhone(Long phone) {
        return memberDao.QueryIdByPhone(phone);
    }
}
