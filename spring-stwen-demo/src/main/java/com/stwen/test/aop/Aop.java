package com.stwen.test.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @description:
 * @author: xianhao_gan
 * @date: 2021/01/12
 **/
public class Aop {


	@Pointcut("execution(* com.stwen.test.aop..*.*(..))")
	private void pointcut(){}

	@After("pointcut()")
	public void advice(){
		System.out.println("之后增强------------");
	}
}
