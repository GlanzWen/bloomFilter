package com.glanz.bloomfilter.service;

import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author GlanzWen
 * @Description 初始化布隆过滤器
 * @github
 */


@Data
public class BloomFilterInit<T> {

    private BloomFilterUtils bloomFilterUtils;

    private RedisTemplate redisTemplate;

    private long bitNum;

    private int hashNum = 1;

    private double errorRate;

    private String initData;



    /**
     *初始化布隆过滤器
     * 需要设计成自定义线程池的方式
     *  位数组大小, hash个数(错误率), 初始化数据
     *
     *  允许的组合 hash与错误率不允许同时存在
     *  (1) 全部
     *  (2) 位数组大小, hash
     *  (3) null
     *  (4) 初始化数据
     */
    public BloomFilterInit() {
        this.initData = null;
        this.bitNum = 32;
        hashNum = 1;
    }

    public BloomFilterInit(String initData) {
        this.initData = initData;
        bloomFilterUtils.add(initData);
    }

    public BloomFilterInit(long bitNum, int hashNum) {
        this.bitNum = bitNum;
        this.hashNum = hashNum;
    }

    public BloomFilterInit(long bitNum, double errorRate) {
        this.bitNum = bitNum;
        this.errorRate = errorRate;
    }

    public BloomFilterInit(RedisTemplate redisTemplate, long bitNum, int hashNum, String initData) {
        this.redisTemplate = redisTemplate;
        this.bitNum = bitNum;
        this.hashNum = hashNum;
        this.initData = initData;
        bloomFilterUtils.add(initData);
    }

    public BloomFilterInit(RedisTemplate redisTemplate, long bitNum, double errorRate, String initData) {
        this.redisTemplate = redisTemplate;
        this.bitNum = bitNum;
        this.errorRate = errorRate;
        this.initData = initData;
        bloomFilterUtils.add(initData);
    }
}
