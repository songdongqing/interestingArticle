package com.sq.bookstore;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
class BookstoreApplicationTests {

	Logger logger = LoggerFactory.getLogger(BookstoreApplicationTests.class);

	@Autowired
	RedisTemplate redisTemplate;

	@Qualifier("dataSource")
	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() {

		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void contextLoads1(){
	    String UUID = getUUID32();
	    System.out.println("UUID:"+UUID);
	}
    public static String getUUID32(){
	    return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    @Test
    void contextLoads2(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        System.out.println("uuid:"+uuid);
    }

    @Test
	void test(){
		logger.info("hello,sdq");
		logger.error("jjjj");
	}

	@Test
	void testRedis(){
		redisTemplate.opsForValue().set("java","我爱java");
		String str =(String) redisTemplate.opsForValue().get("java");
		System.out.println(str);
	}

}
