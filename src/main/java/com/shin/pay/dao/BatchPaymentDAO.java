package com.shin.pay.dao;

import com.shin.pay.entity.BatchPaymentInfo;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
public interface BatchPaymentDAO {

    BatchPaymentInfo queryBatchPaymentInfo(BatchPaymentInfo batchPaymentInfo);
}
