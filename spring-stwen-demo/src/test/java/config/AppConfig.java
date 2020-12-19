package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: spring扫描配置
 * @author: xianhao_gan
 * @date: 2020/12/18
 **/
@ComponentScan("com.example.demo.spring.test")
//@ComponentScan("com.example.demo.spring.annotation")
@Configuration
public class AppConfig {
}
