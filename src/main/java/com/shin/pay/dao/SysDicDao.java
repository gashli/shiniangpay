package com.shin.pay.dao;


import com.shin.pay.entity.SysDic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDicDao extends GenericDao<SysDic>{
	/**
	 * 查询某一个字典类型的详细信息
	 * @param dicType
	 * @return
	 */
	public List<SysDic> getDics(@Param("dicType")String dicType);
}
