package com.demo.springdemo.cache.usersavecache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

@Caching(
        put = {
                @CachePut(cacheNames = "user", key = "#user.id"),
                @CachePut(cacheNames = "user", key = "#user.username"),
                @CachePut(cacheNames = "user", key = "#user.email")
        }
)
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UserSaveCache {
}
