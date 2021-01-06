package com.stwen.test.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xianhao_gan
 * @date: 2021/01/04
 **/
@Component
public class UserServiceImpl implements IUserService{
	@Override
	public void add() {
		System.out.println("------新增用户-----");
	}
}
