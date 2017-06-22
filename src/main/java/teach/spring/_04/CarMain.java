package teach.spring._04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/teach/spring/_04/ApplicationContext.xml");
		IToyCar controller1 =  (IToyCar)ctx.getBean("controller1");//寫法1
//		ToyCar controller1 =  ctx.getBean("controller1", ToyCar.class);//寫法2
//		ToyCar controller1 =  ctx.getBean(ToyCar.class);//寫法3，不用給id，但是有使用限制，給控管ToyCar.class的Bean只能唯一一個，即使nmae不同
		controller1.getDistance();
		
		 ToyCar controller2 = (ToyCar)ctx.getBean("controller1");
		 controller2.setHour(50);
		 controller2.setSpeed(50);
		 controller2.getDistance();
		//
		// IToyCar controller3 = (IToyCar)ctx.getBean("controller1");
		// controller3.getDistance();
		
		
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