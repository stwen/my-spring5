package com.stwen.test.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @description: 自定义的FactoryBean
 * @author: xianhao_gan
 * @date: 2020/12/23
 **/
public class UserFactoryBean implements FactoryBean<IUserService> {


	@Override
	public IUserService getObject() throws Exception {
		// todo 类似装饰器模式，可自定义逻辑
		return new UserServiceImpl();
	}

	@Override
	public Class<?> getObjectType() {
		return IUserService.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
