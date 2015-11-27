package com.shin.pay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author shiliang.gao
 * @since 2015-11-23
 */
public abstract class AbstractBaseRedisDao<K,V> {
    @Autowired
    protected RedisTemplate<K,V> redisTemplate;

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
