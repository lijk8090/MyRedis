package cn.com.infosec.myredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.com.infosec.myredis.entity.UserEntity;
import cn.com.infosec.myredis.service.RedisListService;
import cn.com.infosec.myredis.service.RedisValueService;

@SpringBootTest
class MyRedisApplicationTests {

	@Autowired
	RedisValueService valueService;
	@Autowired
	RedisListService listService;

	@Test
	void testValueService() {

		UserEntity userEntity = new UserEntity();

		valueService.setValue("user", userEntity);
		System.out.println(valueService.getValue("user"));
	}

	@Test
	void testListService() {

		UserEntity userEntity = new UserEntity();
		userEntity.setPassword("12345678");

		listService.pushValue("test", userEntity);
		System.out.println(listService.popValue("test"));
	}
}
