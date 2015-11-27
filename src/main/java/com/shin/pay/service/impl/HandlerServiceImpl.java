package com.shin.pay.service.impl;

import com.shin.pay.annotation.Handler;
import com.shin.pay.annotation.Pair;
import com.shin.pay.service.DictionaryService;
import com.shin.pay.service.HandlerService;
import com.shin.pay.utils.ReflectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
@Service
public class HandlerServiceImpl implements HandlerService {
    private static final Logger logger = LoggerFactory.getLogger(HandlerServiceImpl.class);


    @Autowired
    private DictionaryService service;

    private Map<String, Pair[]> caches = new Hashtable<String, Pair[]>();


    /**
     * 实现注解
     */
    public void excuteAnnotation(Object object) {
        try {
            Pair[] pairs = getAnnotationPairs(object);
            if (null == pairs || pairs.length == 0) {
                logger.info("there are no pairs.ClassName:" + object.getClass().getName());
                return;
            }
            for (Pair pair : pairs) {
                convert(pair, object);
            }
        } catch (Exception e) {
            logger.error("error @ excuteAnnotation for object:" + object.getClass().getName(), e);
        }

    }

    private void convert(Pair pair, Object object) {
        //得到字典中，对应字段需要被转换成的字段值
        Object[] objects = getDescValue(pair, object);
        if (null == objects) {
            return;
        }
        //如果当前字段与字典中的查出的字段不一样，则执行set方法
        if (getTargetName(pair.fieldName(), object, objects)) {
            ReflectUtil.executeSetterMethodByField(object,pair.isToSelf()?pair.fieldName():pair.targetFieldName(), objects, pair.paramType());
        } else {
            return;
        }
    }

    private boolean getTargetName(String name, Object object, Object[] objects) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(name, object.getClass());
            Method getMethod = pd.getReadMethod();

            //得到当前字段值，并将其与字典中获取的值进行比较
            String temp = (String) getMethod.invoke(object);
            if (!temp.equals(objects[0]))
                return true;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;

    }

    private Object[] getDescValue(Pair pair, Object object) {
        Object value = ReflectUtil.executeGetterMehtodByField(object, pair.fieldName(), null);
        if (null == value || value.toString().trim().equals("")) {
            logger.info("value is null @ getter field :" + pair.fieldName());
            return null;
        }
        return getDescValue(service, pair.dicFieldName(), value);
    }

    private Object[] getDescValue(DictionaryService service, String dicFieldName, Object value) {
        if (null == service) {
            return new Object[]{value};
        }
        return new Object[]{
                service.getValue(dicFieldName, value.toString())
        };
    }


    private Pair[] getAnnotationPairs(Object obj) {
        String className = obj.getClass().getName();
        if (!caches.containsKey(className)) {
            loadAnnotation(obj);
        }
        return caches.get(className);

    }

    private void loadAnnotation(Object object) {
        Handler handler = object.getClass().getAnnotation(Handler.class);
        if (null == handler) {
            logger.info("Handler is null.ClassName:" + object.getClass().getName());
            return;
        }
        caches.put(object.getClass().getName(), handler.pairs());
    }

}
