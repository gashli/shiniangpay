package com.shin.pay.dao;

import com.shin.pay.entity.BatchPaymentInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
@Repository
public interface BatchPaymentDAO extends GenericDao<BatchPaymentInfo>{

    BatchPaymentInfo queryBatchPaymentInfo(@Param("batchOrderNo")String batchOrderNo);
}
