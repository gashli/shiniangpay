package com.shin.pay.entity;

import java.util.List;

/**
 * @Author gaoshiliang
 * @Date 15/10/22.
 */
public class PayPriority {

    private List<String> priority;

    public PayPriority() {
    }

    public PayPriority(List<String> priority) {
        this.priority = priority;
    }

    public List<String> getPriority() {
        return priority;
    }

    public void setPriority(List<String> priority) {
        this.priority = priority;
    }

}
