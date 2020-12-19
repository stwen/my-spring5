import com.stwen.test.entity.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @description: 测试
 * @author: xianhao_gan
 * @date: 2020/08/20
 **/
public class MyTest {

	@Test
	public void MyTestBeanTest() {

		// XmlBeanFactory在3.1以后已经被废弃，在读取配置文件时bean就被实例化
		//BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));

//		ApplicationContext  context = new ClassPathXmlApplicationContext("applicaiton.xml");

		// BeanFactory在启动的时候不会创建bean实例,而是在getBean()的时候,才会创建bean的实例?
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);// factory --> BeanDefinitionRegistry
		reader.loadBeanDefinitions("spring-config.xml");
		BeanFactory beanFactory = (BeanFactory) factory;

		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		System.out.println(myTestBean.getName());

		// 注解的方式
//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
//		ac.register(Appconfig.class);
//		ac.refresh();

	}

}
