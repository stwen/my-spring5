package service;

import org.springframework.stereotype.Component;

/**
 * @description: X 被spring注解的类
 * @author: xianhao_gan
 * @date: 2020/12/18
 **/
@Component
public class X {
    public X(){
        System.out.println("X Constructor");
    }
}
