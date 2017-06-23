package teach.spring._05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("teach/spring/_05/Beans.xml");

		Object o1 = ctx.getBean("result1");
		System.out.println("o1=" + o1 + ", class of o1=" + o1.getClass().getName());
		Object o2 = ctx.getBean("result2");
		System.out.println("o2=" + o2 + ", class of o2=" + o2.getClass().getName());
	}

}
