package com.demo.springdemo.cache.mycache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager<T> {

    private Map<String, T> cache =
            new ConcurrentHashMap<String,T>();

    public T getValue(Object key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value) {
        cache.put(key, value);
    }

    // 根据 Key 来删除一条缓存记录
    public void evictCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    // 清空缓存中的记录
    public void evictCache() {
        cache.clear();
    }
}
