package com.stwen.test.factorybean;

/**
 * @description:
 * @author: xianhao_gan
 * @date: 2020/12/23
 **/
public class UserServiceImpl implements IUserService {

	@Override
	public void save() {
		System.out.println("-------保存用户信息-----------");
	}
}
