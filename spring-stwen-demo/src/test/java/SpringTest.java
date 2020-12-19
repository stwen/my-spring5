import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.X;

/**
 * @description: spring 调试测试
 * https://blog.csdn.net/java_lyvee/article/details/102633067
 * https://zhuanlan.zhihu.com/p/82136894
 *
 * @author: xianhao_gan
 * @date: 2020/12/18
 **/
public class SpringTest {

//        当执行完 AbstractApplicationContext 的 invokeBeanFactoryPostProcessors (beanFactory) 方法后
//        beanDefinitionMap 多了一个<x, beanDefinition >，但是后台发现并没有打印 "X Constructor"，这说明这个时候X并没有被实例化，
//        说明spring是先把类扫描出来解析称为一个beanDefintion对象，然后put到beanDefintionMap，
//        后面执行 finishBeanFactoryInitialization(beanFactory) 才会去实例化X
	public static void main(String[] args) {


		// 方式一：启动spring
//		AnnotationConfigApplicationContext ac1 = new AnnotationConfigApplicationContext(AppConfig.class);

		// 方式二：启动spring  注解方式
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

		//动态注册一个配置类 进beanDefinitionMap中
		ac.register(AppConfig.class);
		ac.register(X.class);// 可以显示、动态注册一个程序员提供的bean

		// 初始化spring容器
		ac.refresh();

		System.out.println(ac.getBean(X.class));

	}
}