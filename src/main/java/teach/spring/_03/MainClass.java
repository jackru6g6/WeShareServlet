package teach.spring._03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/teach/spring/_03/ApplicationContext.xml");
		
		Employee emp1 = ctx.getBean("emp1", Employee.class);
		System.out.println(emp1);
	}

}
