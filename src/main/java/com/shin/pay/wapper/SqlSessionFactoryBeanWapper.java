package com.shin.pay.wapper;

import org.mybatis.spring.SqlSessionFactoryBean;

/**
 * 继承SqlSessionFactoryBean用于在初始化完SqlSessionFactory后
 * 调用Configuration.buildAllStatements()来构建所有Statement
 * 以解决高并发时Statement重复构建的问题
 *
 * @Author gaoshiliang
 * @Date 15/10/26.
 */

public class SqlSessionFactoryBeanWapper extends SqlSessionFactoryBean {
    @Override
    public void afterPropertiesSet() throws Exception{
        super.afterPropertiesSet();
        getObject().getConfiguration().buildAllStatements();
    }
}
