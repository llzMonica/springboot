package com.yc.springboot.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.springboot.bean.DmProduct;
import com.yc.springboot.dao.ProductMapper;

@Controller
//默认情况下，所有的方法的返回值都被解析成视图
//template 目录下的文件
public class IndexAction {

	@Resource 
	ProductMapper pm;
	
	@GetMapping("index.do") 
	public String index(Model m) {
		//查询热销商品
		List<DmProduct>  hlist=pm.selectByHot();
		 
		//查询最新商品
		List<DmProduct>  nlist=pm.selectByNew();
		
		//推送给页面 
		m.addAttribute("hlist", hlist);
		m.addAttribute("nlist", nlist); 
		
		//springmvc==》视图解析会将返回的视图名  前+tamplate+视图名+后缀
		return "index";
		
	}
	
	@GetMapping("detail.do")
	public String detail(Model m,int id) {
		//查询指定id的商品
		DmProduct dp=pm.selectById(id);
		System.out.println(dp);
		//推送给页面 
		m.addAttribute("dp", dp); 
		
		//springmvc==》视图解析会将返回的视图名  前+tamplate+视图名+后缀
		return "detail"; 
		
	}
}
