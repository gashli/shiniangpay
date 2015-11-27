//package com.shin.pay.dao.impl;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//
///**
// * @author shiliang.gao
// * @since 2015-11-23
// */
//@Service
//public class RedisTemplateDaoImpl<K,V> {
//    private static final Logger logger = LoggerFactory.getLogger(RedisTemplateDaoImpl.class);
//
//    @Autowired
//    private RedisTemplate<K,V> template;
//
//    @Autowired
//    private ValueOperations<K,V> operations;
//
///*
//    @PostConstruct
//    public void init(V value){
//        template.setValueSerializer(new JacksonJsonRedisSerializer<Object>((Class<Object>) value.getClass()));
//        operations = template.opsForValue();
//    }
//*/
//
//
//    public void set(K key,V value){
//        operations.set(key,value);
//    }
//
//    public V get(K key){
//        return operations.get(key);
//    }
//}
