package com.shin.pay.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author gaoshiliang
 * @Date 15/10/27.
 */
public class ThreadPoolManager {

    private ExecutorService executorService;

    private Integer coreThreadCount=10;

    private Integer maxThreadCount = 20;

    private int queueSize = 10000;

    private long keepAliveTime = 0;

    public void init(){
        executorService = new ThreadPoolExecutor(coreThreadCount,maxThreadCount,keepAliveTime, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize),new ThreadPoolExecutor.AbortPolicy());
    }

    public void destory(){
        executorService.shutdown();
    }

    public void run(Runnable thread){
        executorService.execute(thread);
    }

    public Integer getCoreThreadCount() {
        return coreThreadCount;
    }

    public void setCoreThreadCount(Integer coreThreadCount) {
        this.coreThreadCount = coreThreadCount;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public Integer getMaxThreadCount() {
        return maxThreadCount;
    }

    public void setMaxThreadCount(Integer maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }
}
