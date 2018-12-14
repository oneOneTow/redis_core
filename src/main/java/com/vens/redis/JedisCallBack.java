package com.vens.redis;

import redis.clients.jedis.Jedis;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/12/13
 */
public interface JedisCallBack<T>{
    T execute(Jedis jedis) throws Exception;
}
