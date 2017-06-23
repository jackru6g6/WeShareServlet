package teach.spring._01;

public class Dog extends Mammal {

	String name;

	public Dog(String name) {
		this.name = name;
	}

	static {
		System.out.println("Dog已載入");
	}

	@Override
	public void cry() {
		System.out.println("我是 " + name + ", 我怕打針~~~");
	}

}
