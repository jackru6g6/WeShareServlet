package teach.spring._01;

public class Cat extends Mammal {

	String name;

	public Cat(String name) {
		this.name = name;
	}

	static {
		System.out.println("Catd已載入");
		
		System.out.println("AAAAAAAAA");
	}

	@Override
	public void cry() {
		System.out.println("我是 " + name + ", 我怕打針");
	}

}
