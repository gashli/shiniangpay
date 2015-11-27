package com.shin.pay.service;

import com.shin.pay.redis.RedisCache;
import com.shin.pay.dao.SysDicDao;
import com.shin.pay.entity.SysDic;
import com.shin.pay.main.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @author shiliang.gao
 * @since 2015-11-23
 */
public class SysTest extends BaseTest{

    @Autowired
    SysDicDao sysDicDao;

    @Autowired
    private RedisTemplate<String,String> template;

//    private ValueOperations<String,SysDic> operations;

    @Autowired
    private RedisCache redisCache;

//    @PostConstruct
//    public void init(){
//        template.setValueSerializer(new JacksonJsonRedisSerializer<>(SysDic.class));
//        operations = template.opsForValue();
//    }


    public void set(String key,String value){
        template.opsForValue().set(key,value);
    }

    public String get(String key){
        return template.opsForValue().get(key);
    }

    @Test
    public void SysDicTest(){
        List<SysDic> dics=sysDicDao.getDics("busiType");
        System.out.println("--------"+dics);
        set("aaa", dics.get(0).toString());
        String sysDic = get("aaa");
        System.out.println("======="+sysDic);
    }

    @Test
    public void SysDicTest_B(){
        List<SysDic> dics=sysDicDao.getDics("busiType");
        System.out.println("--------" + dics);
//        set("aaa", dics.get(0));
        redisCache.setRedisCache("aaa",dics);
        SysDic sysDic = redisCache.getRedisCache("aaa",SysDic.class);
        System.out.println("======="+sysDic);
    }

}
