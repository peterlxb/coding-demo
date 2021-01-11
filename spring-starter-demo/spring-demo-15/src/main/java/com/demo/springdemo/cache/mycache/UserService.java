package com.demo.springdemo.cache.mycache;

import com.demo.springdemo.cache.domain.User;

public class UserService {

    private CacheManager<User> cacheManager;

    public UserService() {
        cacheManager = new CacheManager<User>();
    }

    public User getUserById(String userId) {

        // 首先查询缓存
        User result = cacheManager.getValue(userId);
        if (result != null) {
            System.out.println("get from cache:" +userId);

            // 在缓存中，则直接返回缓存的结果
            return result;
        }

        // 否则查询数据库
        result = getFromDB(userId);
        if (result != null) {
            // 将数据库查询的结果更新到缓存中
            cacheManager.addOrUpdateCache(userId, result);
        }

        return result;
    }

    public void reload() {
        cacheManager.evictCache();
    }

    private User getFromDB(String userId) {
        System.out.println("real query db..."+userId);
        return new User(userId);
    }
}
