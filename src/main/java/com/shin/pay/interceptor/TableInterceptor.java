package com.shin.pay.interceptor;

import com.shin.pay.entity.Entity;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Map;
import java.util.Properties;

/**
 * @author shiliang.gao
 * @since 2015-11-23
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})})
public class TableInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        Object param = invocation.getArgs()[1];
        if (param != null && param instanceof Map<?, ?> && MapUtils.isNotEmpty((Map<Object, Object>) param)) {
            for (Map.Entry<Object, Object> entry : ((Map<Object, Object>) param).entrySet()) {
                setTableName(entry.getValue());
            }
        } else if (param != null && param instanceof Entity) {
            setTableName(param);
        }
        return invocation.proceed();
    }

    private void setTableName(Object obj) {
        if (obj != null && obj instanceof Entity) {
            String tableName = TableNameUtil.getTableName(obj);
            if (StringUtils.isNotEmpty(tableName)) {
                ((Entity) obj).setTableName(tableName);
            }
        }
    }

    public Object plugin(Object o) {
        return null;
    }

    public void setProperties(Properties properties) {

    }
}
