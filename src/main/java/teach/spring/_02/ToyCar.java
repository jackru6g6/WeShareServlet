package teach.spring._02;

public class ToyCar implements IToyCar {
	int speed;
	double hour;

	public ToyCar() {
	}

	public ToyCar(int speed, double hour) {
		super();
		this.speed = speed;
		this.hour = hour;
	}

	/* (non-Javadoc)
	 * @see teach.spring._02.IToyCar#getDistance()
	 */
	@Override
	public void getDistance() {
		System.out.println("此玩具車走了" + speed * hour + "公里");
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
	}

}
