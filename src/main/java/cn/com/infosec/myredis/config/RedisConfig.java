package cn.com.infosec.myredis.config;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		logger.info("RedisTemplate");

		RedisTemplate<String, Object> templage = new RedisTemplate<String, Object>();

		templage.setConnectionFactory(factory);

		templage.setKeySerializer(new StringRedisSerializer());
		templage.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
		templage.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

		templage.setEnableTransactionSupport(true);
		return templage;
	}

	@Bean
	public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {
		logger.info("redisCacheManager");

		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30L));
		RedisCacheManager manager = RedisCacheManager.builder(factory).cacheDefaults(config).build();
		return manager;
	}

	@Bean
	public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
		logger.info("valueOperations");

		return redisTemplate.opsForValue();
	}

	@Bean
	public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
		logger.info("ListOperations");

		return redisTemplate.opsForList();
	}

	@Bean
	public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
		logger.info("SetOperations");

		return redisTemplate.opsForSet();
	}

	@Bean
	public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
		logger.info("HashOperations");

		return redisTemplate.opsForHash();
	}
}
