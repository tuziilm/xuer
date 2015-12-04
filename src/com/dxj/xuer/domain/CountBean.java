package com.dxj.xuer.domain;

/**
 * Author: <a href="tuziilm@163.com">Tuziilm</a>
 * Date: 15-12-4
 * Time: ÏÂÎç3:57
 */
public class CountBean {
    private int count;

    public int getCount() {
        return ++count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}