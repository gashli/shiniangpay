package com.shin.pay.service.impl;

import com.google.common.base.Strings;
import com.shin.pay.annotation.ArithmeticEnum;
import com.shin.pay.annotation.Table;
import com.shin.pay.utils.Constants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author shiliang.gao
 * @since 2015-12-07
 */
public class TableNameServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TableNameServiceImpl.class);

    /**
     * 通过反射得到注解计算出表名
     * @param obj
     * @return
     */
    public static String getTableName(Object obj) {
        try {
            Table tableRoute = obj.getClass().getAnnotation(Table.class);
            if (tableRoute != null) {
                String column = tableRoute.column();
                ArithmeticEnum arithmetic = tableRoute.arithmetic();
                String prefix = tableRoute.prefix();
                Integer count = tableRoute.count();
                PropertyDescriptor pd = new PropertyDescriptor(column, obj.getClass());
                Method m = pd.getReadMethod();
                Object _obj = m.invoke(obj);
                return prefix + getSuffix(arithmetic, _obj, count);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return "";
    }

    /**
     * 计算表名后缀
     * @param arithmetic
     * @param obj
     * @param count
     * @return
     */
    private static String getSuffix(ArithmeticEnum arithmetic, Object obj, Integer count) {
        Integer length = String.valueOf(count).length();
        if (arithmetic.equals(ArithmeticEnum.HASH)) {
            return Strings.padStart(String.valueOf(Math.abs(obj.hashCode() % count)), length, Constants.PAD_CHAR);
        } else {
            String temp = (String) obj;
            temp = StringUtils.substring(temp, temp.length() - Constants.LENGTH);
            return Strings.padStart(String.valueOf(Long.valueOf(temp) % count), length, Constants.PAD_CHAR);
        }
    }
}
