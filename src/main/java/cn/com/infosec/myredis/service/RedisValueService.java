package cn.com.infosec.myredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisValueService {

	@Autowired
	private ValueOperations<String, Object> valueOperations;

	@Cacheable("user")
	public Object getValue(String key) {
		return this.valueOperations.get(key);
	}

	@Cacheable("user")
	public void setValue(String key, Object value) {
		this.valueOperations.set(key, value);
	}

}
