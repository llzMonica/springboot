package com.yc.springboot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.springboot.biz.MailService;
import com.yc.springboot.dao.ProductMapper;

@SpringBootTest
class SpringbootApplicationTests {

	@Resource
	ProductMapper pm;
	
	@Resource
	MailService ms;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void Test01() {
		Assert.isTrue(pm.selectAll().size()>0,"没有数据");
	}
	
	@Test
	void testMail() {
		ms.sendSimpleMail("2438796862@qq.com", "体面", "我爱过你，利落干脆");
	}
 
}
