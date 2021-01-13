package com.stwen.test.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: https://blog.csdn.net/gongsenlin341/article/details/111240114
 *
 * @author: xianhao_gan
 * @date: 2021/01/04
 **/
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		A a = ac.getBean(A.class);
		a.f();
	}
}
