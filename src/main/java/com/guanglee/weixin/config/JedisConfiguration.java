package com.guanglee.weixin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfiguration {
	@Autowired
	private JedisConfig redisConfig;
	
	@Bean
	public JedisConnectionFactory convertJedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(redisConfig.getHost());
		jedisConnectionFactory.setPort(redisConfig.getPort());
		jedisConnectionFactory.setPassword(redisConfig.getPassword());
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(redisConfig.getMaxTotal());
		jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());
		jedisPoolConfig.setMinIdle(redisConfig.getMinIdle());
		jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
		jedisPoolConfig.setTestOnBorrow(redisConfig.isTestOnBorrow());
		jedisPoolConfig.setTestOnReturn(redisConfig.isTestOnReturn());
		jedisPoolConfig.setTestWhileIdle(redisConfig.isTestWhileIdle());

		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		return jedisConnectionFactory;
	}
}
