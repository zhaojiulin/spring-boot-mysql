package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * RedisCache
 *
 * @author zjl
 * @date 2018/8/31
 */
public class RedisCache {

    @Autowired
    JedisPool jedisPool;

    public void setCode(String key, String code) {
        Jedis jedis = this.jedisPool.getResource();
        try {
            jedis.set(key, code);
            jedis.expire(key, 60 * 2);
        } finally {
            jedis.close();
        }
    }

    public void delCode(String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.del(key);
        jedis.close();
    }

    public String getCode(String key) {
        Jedis jedis = this.jedisPool.getResource();
        try {
            return jedis.get(key);
        } finally {
            jedis.close();
        }
    }
}
