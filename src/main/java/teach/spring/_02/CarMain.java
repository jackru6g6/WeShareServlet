package teach.spring._02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		// ToyCar controller1 = new ToyCar();
		// controller1.hour = 2;
		// controller1.speed = 10;
		Class<Integer> c1 = int.class;
		Class<String> c2 = String.class;
		Class<ToyCar> c3 = ToyCar.class;
		Object o1 = new Object();
		Object o2 = new ToyCar();
		Object o3 = "123";
		
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/teach/spring/_02/ApplicationContext.xml");
		IToyCar controller1 =  (IToyCar)ctx.getBean("controller1");//寫法1
//		ToyCar controller1 =  ctx.getBean("controller1", ToyCar.class);//寫法2
//		ToyCar controller1 =  ctx.getBean(ToyCar.class);//寫法3，不用給id，但是有使用限制，給控管ToyCar.class的Bean只能唯一一個，即使nmae不同
		controller1.getDistance();
		
		IToyCar controller2 =  (IToyCar)ctx.getBean("controller1");
		controller1.getDistance();
		
		IToyCar controller3 =  (IToyCar)ctx.getBean("controller1");
		controller1.getDistance();
		
		
		((ConfigurableApplicationContext)ctx).close();
		// controller1.getDistance(); // 此行印出『此玩具車走了20.0公里』
		//
		// ToyCar controller2 = controller1;
		// controller2.hour = 1;
		// controller2.speed = 5;
		//
		// controller1.getDistance(); // 此行印出何種訊息?
	}
}
// 問題1:本題產生幾個物件?
// 問題2:最後一行敘述會印出何種訊息?