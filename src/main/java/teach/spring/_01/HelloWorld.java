package teach.spring._01;

public class HelloWorld implements Regard {
	String message;
	Mammal mammal;

	static {
		System.out.println("HelloWorld已載入");
	}
	
	public Mammal getMammal() {
		return mammal;
	}

	public void setMammal(Mammal mammal) {
		this.mammal = mammal;
	}

	@Override
	public void vaccinate() {
		mammal.cry();

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void sayHello() {
		System.out.println(message);

	}

}
