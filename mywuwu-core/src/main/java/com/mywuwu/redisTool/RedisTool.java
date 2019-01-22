package com.mywuwu.redisTool;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class RedisTool {

    public static String inc(RedisTemplate redisTemplate, String key, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, Objects.requireNonNull(redisTemplate.getConnectionFactory()));
        Long increment = entityIdCounter.getAndIncrement();

        if (increment.longValue() == 0 && liveTime > 0) {//初始设置过期时间
            entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
        }

        return increment.toString();
    }
}
