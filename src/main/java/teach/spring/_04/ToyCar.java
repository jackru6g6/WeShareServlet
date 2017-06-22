package teach.spring._04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("controller1")
@Scope("prototype")
public class ToyCar implements IToyCar {

	Integer speed;
	
	Double hour;

	public ToyCar() {
	}

	public ToyCar(int speed, double hour) {
		super();
		this.speed = speed;
		this.hour = hour;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see teach.spring._02.IToyCar#getDistance()
	 */
	@Override
	public void getDistance() {
		System.out.println("此玩具車走了" + speed * hour + "公里");
	}

	public int getSpeed() {
		return speed;
	}

	@Resource
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getHour() {
		return hour;
	}

	@Resource
	public void setHour(double hour) {
		this.hour = hour;
	}

}
