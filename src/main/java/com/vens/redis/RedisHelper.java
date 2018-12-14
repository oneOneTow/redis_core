package com.vens.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author LuZhiqing
 * @Description: jedis对象不是线程安全的
 * @date 2018/12/13
 */
public class RedisHelper {
    private JedisPool jedisPool;
    private ShardedJedisPool shardedJedisPool;

    public RedisHelper() {
    }

    public RedisHelper(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public RedisHelper(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }

    public RedisHelper(JedisPool jedisPool, ShardedJedisPool shardedJedisPool) {
        this.jedisPool = jedisPool;
        this.shardedJedisPool = shardedJedisPool;
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    public ShardedJedis getShardedJedis() {
        return shardedJedisPool.getResource();
    }

    public <T> T jedisExecute(JedisCallBack<T> call) throws Exception{
        Jedis jedis = getJedis();
        try {
            return call.execute(jedis);
        } catch (JedisConnectionException e) {
            return call.execute(jedis);
        } finally {
            jedis.close();
        }
    }

    public <T> T jedisExecute(JedisCallBack<T> call, T defaultValue) throws Exception{
        Jedis jedis = getJedis();
        T result = null;
        try {
            result = call.execute(jedis);
        } catch (JedisConnectionException e) {
            result = call.execute(jedis);
        } finally {
            jedis.close();
            return result == null ? defaultValue : result;
        }
    }

    public <T> T shardedJedisExecute(ShardedJedisCallBack<T> call) throws Exception{
        ShardedJedis shardedJedis = getShardedJedis();
        try {
            return call.execute(shardedJedis);
        } catch (JedisConnectionException e) {
            return call.execute(shardedJedis);
        } finally {
            shardedJedis.close();
        }
    }

    public <T> T shardedJedisExecute(ShardedJedisCallBack<T> call, T defaultValue) throws Exception{
        ShardedJedis shardedJedis = getShardedJedis();
        T result = null;
        try {
            result = call.execute(shardedJedis);
        } catch (JedisConnectionException e) {
            result = call.execute(shardedJedis);
        } finally {
            shardedJedis.close();
            return result == null ? defaultValue : result;
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }
}
