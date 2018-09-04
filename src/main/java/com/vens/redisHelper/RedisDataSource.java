package com.vens.redisHelper;

import redis.clients.jedis.ShardedJedis;

public interface RedisDataSource {
    ShardedJedis getRedisClient();
    void returnResource(ShardedJedis shardedJedis);
    void returnResource(ShardedJedis shardedJedis, boolean broken);
}
