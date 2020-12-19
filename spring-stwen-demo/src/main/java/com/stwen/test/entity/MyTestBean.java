package com.stwen.test.entity;

/**
 * @description:
 * @author: xianhao_gan
 * @date: 2020/08/20
 **/
public class MyTestBean {
	private String name = "stwen_gan";

	public MyTestBean(String name) {
		this.name = name;
	}

	public MyTestBean() {
	}

	@Override
	public String toString() {
		return "MyTestBean{" +
				"name='" + name + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
