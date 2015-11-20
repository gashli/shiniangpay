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
    public String dicFieldName() default "";

    /**
     * 映射字段类型(反射中，参数类型)
     * */
    public Class<? extends Object>[] paramType() default {String.class};

    /**
     * 映射目标字段，如将userName映射到userId
     * */
    public String targetFieldName() default "";




}
