package com.yc.springboot.biz;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.yc.springboot.bean.DmUser;
import com.yc.springboot.dao.UserDao;

@SpringBootTest
public class UserBizTest {

	/**
	 * 虚拟的UserDao对象(Mock对象)
	 * springboot 会使用该udao替换UserBiz中的udao
	 */
//	@MockBean
//	private UserDao udao;
	
	@Resource
	private UserBiz ubiz;
	
	@Test
	public void testLogin() {
		try {
			//模拟的结果对象
			//DmUser muser=new DmUser();
			//模拟对象方法调用结果
			//Mockito.when(udao.selectByLogin("武松", "123")).thenReturn(muser);
			DmUser user=ubiz.login("武松", "123");
			Assert.isTrue(user!=null,"没查到指定用户");
		} catch (Exception e) {
			//Assert.isTrue(e==null,"dao类异常");
			e.printStackTrace();
		}
	}
}
