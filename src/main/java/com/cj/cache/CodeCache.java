package com.cj.cache;


import java.util.LinkedHashMap;
import java.util.Map;

public class CodeCache {
    private Map<Long, String> codeMap;
    private static CodeCache instance;

    private CodeCache() {
        codeMap = new LinkedHashMap<Long, String>();
    }

    public static CodeCache getInstance() {
        if (instance == null) {
            instance = new CodeCache();
        }
        return instance;
    }

    public boolean saveCode(Long phone, String code) {
        if (codeMap.get(phone) == null) {
            codeMap.put(phone, code);
            return true;
        }
        return false;
    }

    public String getCode(Long phone) {
        return codeMap.get(phone);
    }
}
