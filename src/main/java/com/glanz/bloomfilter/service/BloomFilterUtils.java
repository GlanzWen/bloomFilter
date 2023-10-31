package com.glanz.bloomfilter.service;

import cn.hutool.core.lang.hash.Hash32;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author GlanzWen
 * @Description 布隆过滤器提供的方法类
 * @github
 */
public class BloomFilterUtils implements BloomFilterUtil{

    private BloomFilterInit bloomFilterInit;

    private RedisTemplate redisTemplate;

    private Hash32 hash32;

    @Override
    public int getHash(String checkItem) {
        int hash = 0;
        for (int i = 0; i <bloomFilterInit.getHashNum() ; i++) {
            checkItem += 1;
            hash = hash32.hash32(checkItem);
        }
        return hash;
    }

    @Override
    public long getIndex(String checkItem) {
        return (long) (Math.abs(getHash(checkItem)) % Math.pow(2, bloomFilterInit.getBitNum()));
    }

    @Override
    public boolean check(String checkItem, String key) {
        boolean isExist = redisTemplate.opsForValue().getBit(checkItem, getIndex(key));
        return isExist;
    }

    @Override
    public boolean add(String checkItem) {
        long index = getIndex(checkItem);
        boolean isExist = redisTemplate.opsForValue().getBit(checkItem, index);
        if (isExist) return true;
        redisTemplate.opsForValue().setBit(checkItem, index, true);
        return true;
    }
}
