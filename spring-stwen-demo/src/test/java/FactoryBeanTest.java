import com.stwen.test.factorybean.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: xianhao_gan
 * @date: 2020/12/23
 **/
public class FactoryBeanTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("spring-config.xml");

		// 这里重点，关注 getBean 方法源码
		IUserService bean = cxa.getBean(IUserService.class);
		System.out.println(bean);
	}
}
