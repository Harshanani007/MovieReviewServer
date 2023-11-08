package com.example.server.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisHostController {

    @Value("${REDIS_HOST}")
    private String redisHost;

    @GetMapping("/redis-host")
    public String getRedisHost() {
        return redisHost;
    }
}
