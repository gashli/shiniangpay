package com.shin.pay.utils;

import com.google.common.base.Strings;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shiliang.gao
 * @since 2015-11-16
 */
public class SerialNumberGernerate {

    private static final int MAX_INT = 9999999;

    private static final String TIME_FORMAT = "yyyyMMddHHmmss";

    private static final String IP = IpUtil.getLocalIP();

    private static final int LENGTH = 7;

    private static final char PAD_CHAR = '0';

    private final String mark;

    private final AtomicInteger atomicInteger;

    public SerialNumberGernerate(String mark) {
        this.mark = mark;
        atomicInteger = new AtomicInteger(new Random().nextInt(2 << 10));
    }

    public String getSeqNumber() {
        String time = DateFormatUtils.format(new Date(), TIME_FORMAT);
        StringBuilder sb = new StringBuilder(time);
        sb.append(IP);
        sb.append(mark);
        int dataId = atomicInteger.incrementAndGet();
        if (dataId > MAX_INT) {
            atomicInteger.compareAndSet(dataId, 0);
            dataId = atomicInteger.incrementAndGet();
        }
        sb.append(Strings.padStart(String.valueOf(dataId), LENGTH, PAD_CHAR));
        return sb.toString();
    }

    public static void main(String[] args) {
        SerialNumberGernerate numberGernerate = new SerialNumberGernerate("PAY");
        System.out.println(numberGernerate.getSeqNumber());
    }

}
