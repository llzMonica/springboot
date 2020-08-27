package com.yc.springboot.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.springboot.bean.DmUser;
import com.yc.springboot.dao.UserDao;
import com.yc.springboot.exception.BizException;

/**
 * 由李四开发的UserBiz已经完成
 * @author 李玲芝
 *
 */
@Service
public class UserBiz {

	@Resource
	private UserDao udao;
	
	public DmUser login(String name,String pwd) throws BizException {
		
		DmUser user=udao.selectByLogin(name, pwd);
	
		if(user==null) {
			throw new BizException("用户名或密码错误！");
		}
		
		return user;
	}
}
