package com.ctj.util;

/**
 * Created by tingjie.cao on 2016/9/23.
 * 计数器 主要是测试算法执行时间
 */
public class Timer {
    private long start;
    public Long start(){
        return this.start = System.currentTimeMillis();
    }

    public double soutTime(){
        return (System.currentTimeMillis() - this.start) / 1000.0;
    }

    public void clean(){
        this.start = 0L;
    }
}
