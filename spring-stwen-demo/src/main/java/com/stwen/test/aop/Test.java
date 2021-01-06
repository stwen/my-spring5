package com.stwen.test.aop;

import com.stwen.test.config.MyConfig;
import com.stwen.test.service.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: https://blog.csdn.net/a1036645146/article/details/112172174
 * @author: xianhao_gan
 * @date: 2021/01/04
 **/
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(MyConfig.class);
		// 测试spring默认的aop代理方式是jdk还是cglib
		IUserService bean = context.getBean(IUserService.class);
		bean.add();
	}
}
