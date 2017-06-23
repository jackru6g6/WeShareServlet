package teach.spring._01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/teach/spring/_01/Beans.xml");
		Regard reg1 = (Regard) context.getBean("/helloName");// 寫法1，getBean("可以是id或者name")
//		Regard reg2 = context.getBean(Regard.class, "hello");// 寫法2

//		reg1.sayHello();
////		reg2.sayHello();
//		
//		reg1.vaccinate();
	}

}
