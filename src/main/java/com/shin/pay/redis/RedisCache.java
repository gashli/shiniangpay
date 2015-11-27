package com.shin.pay.redis;

/**
 * @author shiliang.gao
 * @since 2015-11-24
 */
public interface RedisCache {
    public <T> T getRedisCache(String key,Class<T> clazz);

    public <T> boolean setRedisCache(String key,T value);
}
