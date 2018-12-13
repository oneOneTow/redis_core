package com.vens.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/12/13
 */
public interface ShardedJedisCallBack <T>{
    T execute(ShardedJedis jedis);
}
