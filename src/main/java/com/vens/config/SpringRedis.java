//package com.vens.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.jedis.JedisShardInfo;
//import redis.clients.jedis.ShardedJedisPool;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class SpringRedis {
//    @Bean
//    public JedisPoolConfig getJedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(8);
//        jedisPoolConfig.setMaxIdle(4);
//        jedisPoolConfig.setMinIdle(1);
//        jedisPoolConfig.setMaxWaitMillis(3000);
//        jedisPoolConfig.setMinEvictableIdleTimeMillis(30000);
//        jedisPoolConfig.setNumTestsPerEvictionRun(3);
//        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(60000);
//        jedisPoolConfig.setTestOnBorrow(true);
//        jedisPoolConfig.setTestOnCreate(true);
//        return jedisPoolConfig;
//    }
//    @Bean
//    public ShardedJedisPool shardedJedisPool() {
//        JedisPoolConfig jedisPoolConfig=getJedisPoolConfig();
//        List<JedisShardInfo> jedisShardInfos=new ArrayList<JedisShardInfo>();
//        JedisShardInfo jedisShardInfo=new JedisShardInfo("119.29.75.134","6379");
//        jedisShardInfo.setPassword("746kobe");
//        jedisShardInfos.add(jedisShardInfo);
//        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig,jedisShardInfos);
//        return shardedJedisPool;
//    }
//}
