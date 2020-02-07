package com.cj.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class TokenCache {
    private Map<String, Long> tokenMap;
    private static TokenCache instance;

    private TokenCache() {
        tokenMap = new LinkedHashMap<String, Long>();
    }

    public static TokenCache getInstance() {
        if (instance == null) {
            instance = new TokenCache();
        }
        return instance;
    }

    public void saveToken(String token, Long phone) {
        tokenMap.put(token, phone);
    }

    public Long getPhone(String token) {
        return tokenMap.get(token);
    }
}
