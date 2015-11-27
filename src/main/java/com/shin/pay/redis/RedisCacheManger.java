package com.shin.pay.redis;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


/**
 * @author shiliang.gao
 * @since 2015-11-24
 */
public class RedisCacheManger implements RedisCache {
    private static final Logger logger = LoggerFactory.getLogger(RedisCacheManger.class);

    private ShardedJedisPool pool;

    public <T> T getRedisCache(String key,Class<T> clazz) {
        try {
            logger.info("get data from redis cache:"+key);
            ShardedJedis jedis = pool.getResource();
            String value = jedis.get(key);
            JSONObject jsonObject = new JSONObject();
            jsonObject = jsonObject.getJSONObject(value);
            return (T)JSONObject.toBean(jsonObject, (Class) clazz);
        }catch (Exception e){
            logger.info("get data from redis cache fail : "+key);
        }
        return null;
    }

    public <T> boolean setRedisCache(String key, T value) {
        try {
            logger.info("add redis cache:"+key);
            ShardedJedis jedis = pool.getResource();
            jedis.set(key, JSONArray.fromObject(value).toString());
            return true;
        }catch (Exception e){
            logger.info("add redis cache fail:"+key);
        }
        return false;
    }

    public ShardedJedisPool getPool() {
        return pool;
    }

    public void setPool(ShardedJedisPool pool) {
        logger.info("======== = = = = set pool" + pool);
        this.pool = pool;
    }
}
