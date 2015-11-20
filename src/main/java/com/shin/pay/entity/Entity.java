package com.shin.pay.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
public class Entity<Object extends Serializable> implements Serializable {

    private static final long serialVersionUID = 5672660404230566052L;

    private Long id;

    private Date createTime;

    private Date updateTime;

    private String tableName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
