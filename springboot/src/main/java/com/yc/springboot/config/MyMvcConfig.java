package com.yc.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//我们接管了webmvc，自动配置将会失效
//@Configuration   //使用@Configuration会将当前配置类加载到容器中
public class MyMvcConfig implements WebMvcConfigurer{  
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index"); 
		registry.addViewController("/index.html").setViewName("index");
		registry.addViewController("/test").setViewName("index");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		
		 InterceptorRegistration registration =registry.addInterceptor(new LoginHandlerInterceptor());
		
		 registration.addPathPatterns("/**"); 
		 registration.excludePathPatterns(
				 "/index.html",
				 "/","/login.html","/",
				 "/css/**","/js/**","/images","/image");
	}

	
	
}
