package config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import service.Y;

/**
 * @description: 自定义实现 BeanFactory后置处理器
 *      * beanFactory是怎么new出来的（实例化），BeanFactoryPostProcessor是干预不了的，
 *      * 但是beanFactory new出来之后各种属性的填充或者修改（初始化）是可以通过BeanFactoryPostProcessor来干预
 *
 * @author: xianhao_gan
 * @date: 2020/12/18
 **/
@Component
public class TestBeanFactoryPostPorcessor implements BeanFactoryPostProcessor {
    /**
     *
     * 注：项目里面有三个类X，Y，Z，其中只有X加了@Component注解；也就是当代码执行到上面那个方法的时候只扫描到了X；
     * beanFactory里的beanDefinitionMap当中也只有X所对应的beanDefinition对象；
     * 笔者首先new了一个Y所对应的beanDefinition对象然后调用registerBeanDefinition("y", y)；
     * 把y对应的beanDefinition对象put到beanDefinitionMap，这是演示动态添加一个自己实例化的beanDefinition对象；
     * 继而又调用getBeanDefinition("x")得到一个已经存在的beanDefinition对象，然后调用x.setBeanClassName("Z");
     * 把x所对应的beanDefinition对象所对应的class改成了Z，这是演示动态修改一个已经扫描完成的beanDefinition对象；
     *
     * @param beanFactory 入参：已经实例化好的beanFactory对象,可以对它修改扩展
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //转换为子类，因为父类没有添加beanDefintion对象的api
        DefaultListableBeanFactory defaultbf =
                (DefaultListableBeanFactory) beanFactory;

        //new一个Y的beanDefinition对象，方便测试动态添加
        GenericBeanDefinition y = new GenericBeanDefinition();
        y.setBeanClass(Y.class);
        //添加一个beanDefinition对象，原本这个Y没有被spring扫描到
        defaultbf.registerBeanDefinition("y", y);

        //得到一个已经被扫描出来的beanDefintion对象x
        //因为X本来就被扫描出来了，所以是直接从map中获取
        BeanDefinition x = defaultbf.getBeanDefinition("x");
        //修改这个X的beanDefintion对象的class为Z
        //原本这个x代表的class为X.class；现在为Z.class
        x.setBeanClassName("com.example.demo.spring.test.Z");
    }

}
