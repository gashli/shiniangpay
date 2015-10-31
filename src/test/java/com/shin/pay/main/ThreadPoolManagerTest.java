package com.shin.pay.main;

import com.shin.pay.job.SendMsgJob;
import com.shin.pay.utils.ThreadPoolManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author gaoshiliang
 * @Date 15/10/27.
 */
public class ThreadPoolManagerTest extends BaseTest {

    @Autowired
    private ThreadPoolManager poolManager;

    @Test
    public void ThreadPoolManagerTest_A(){
        for (int i=0;i<10000;i++){
            poolManager.run(new SendMsgJob());
        }
    }
}
