package com.shin.pay.dao;

import com.shin.pay.entity.Entity;

import java.util.List;

/**
 * @author shiliang.gao
 * @since 2015-11-23
 */
public interface GenericDao<E extends Entity> {
    /**
     * 保存
     * */
    void save(E obj);

    /**
     * 修改
     * */
    void update(E obj);

    /**
     * 删除
     * */
    void delete(E obj);

    /**
     * 得到实体
     * */
    E queryOne(E obj);

    /**
     * 查询列表
     * */
    List<E> queryList(Object... objects);
}
