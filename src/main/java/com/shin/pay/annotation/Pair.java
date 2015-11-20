package com.shin.pay.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Pair {

    /**
     * 映射字段名称 如userName
     * */
    public String fieldName();

    /**
     * 对应的字典字段名称，如存userName的字典表，其表的列名为name
     * */
    public String dicFieldName();

    /**
     * 映射字段类型，如userName为enum
     * */
    public Class<? extends Object>[] paramType() default {String.class};

    /**
     * 存到数据库时，字段类型，如将enum转换为String
     * */
    public Class<? extends Object>[] targetType() default {String.class};

    /**
     * 映射目标字段，如将userName映射到userId
     * */
    public String targetFieldName();




}
