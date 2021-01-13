package com.stwen.test.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: xianhao_gan
 * @date: 2021/01/12
 **/
//配置类 不变
@Configuration
@ComponentScan("com.stwen.test.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
