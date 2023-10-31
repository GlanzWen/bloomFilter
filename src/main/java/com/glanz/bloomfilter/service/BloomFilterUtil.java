package com.glanz.bloomfilter.service;

/**
 * @Author GlanzWen
 * @Description Something
 * @github
 */
public interface BloomFilterUtil {

    //计算hash ->  调用hutool
    /**
     * 计算每个组件的hash值
     *  T -> 传进来的参数 需要计算hash的参数
     */
    public abstract int getHash(String checkItem);

    /**
     * 计算占位
     *
     */
    public abstract long getIndex(String checkItem);

    /**
     *  检查是否存在
     */
    public abstract boolean check(String checkItem, String key);

    /**
     * 加入新值
     */
    public abstract boolean add(String checkItem);

}
