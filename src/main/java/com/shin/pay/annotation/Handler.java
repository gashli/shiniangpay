package com.shin.pay.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Handler {
    Pair[] pairs() default {};
    Table table();
}
