package cn.com.infosec.myredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisListService {

	@Autowired
	ListOperations<String, Object> listOperations;

	@Cacheable("test")
	public Object popValue(String key) {
		return this.listOperations.rightPop(key);
	}

	@Cacheable("test")
	public void pushValue(String key, Object value) {
		this.listOperations.leftPush(key, value);
	}

}
