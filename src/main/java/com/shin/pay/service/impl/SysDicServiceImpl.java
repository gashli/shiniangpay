package com.shin.pay.service.impl;

import com.google.common.collect.Maps;
import com.shin.pay.dao.SysDicDao;
import com.shin.pay.entity.SysDic;
import com.shin.pay.service.DictionaryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
@Service
public class SysDicServiceImpl implements DictionaryService {

    private static final Logger logger = LoggerFactory.getLogger(SysDicServiceImpl.class);

    @Autowired
    private SysDicDao sysDicDao;

    public String getValue(String type, String key) {
        if (StringUtils.isBlank(type)||StringUtils.isBlank(key)){
            return key;
        }
        String value = toMap(sysDicDao.getDics(type)).get(key);
        if (StringUtils.isBlank(value)){
            logger.error("can't find value :{},key:{}",type,key);
            return key;
        }
        return value;
    }

    private Map<String,String> toMap(List<SysDic> sysDics){
        Map<String,String> result = Maps.newHashMap();
        if (CollectionUtils.isEmpty(sysDics)){
            return result;
        }
        for (SysDic sysDic:sysDics){
            result.put(sysDic.getCode(),sysDic.getTitle());
        }
        return result;
    }
}
