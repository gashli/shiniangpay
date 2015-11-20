package com.shin.pay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

    public String prefix() default "";

    public String column() default "";

    public ArithmeticEnum arithmetic() default ArithmeticEnum.MODE;

    public int count() default 1;
}