package com.stwen.test.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xianhao_gan
 * @date: 2021/01/12
 **/
@Component
public class A {

	@Autowired
	B b;

	public void f(){
		System.out.println("AAAAA");
	}
}
