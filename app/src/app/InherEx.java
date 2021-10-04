package app;

/*
 * 상속(Inheritance)
	 - 상속이란 자식이 부모가 가지고 있는 재산이나 권력을 물려받는다는 의미.
	 - 특정(자식)클래스는 다른(부모)클래스가 가지고 있는 모든 멤버변수나 멤버 메소드를 사용할 수 있음.
	 - 상속 관계에서 자식클래스의 객체를 생성했을 때 부모 클래스의 객체도 생성되어짐.
	 - 상속 관계 표현으로 extends keyword를 사용함.
	 - 상속 관계 용어로 super, 상위, 부모 class와 sub, 하위, 자식 class로 사용함
	 - 상속의 개념에서 super와 this를 구분함.
	 - 메서드를 재사용할 수 있음(method override).
	 - 단일 상속(자바에서는 다증 상속 x)
	 - extends 와 implements를 함께 사용할 수 있음.
 형식)
 	class A extends B{
 		문장 구현;
 	}
 */



public class InherEx extends SuperClass implements B2{

	int c = 20;
	public InherEx() {
		super();//이것이 숨겨져있다.
		System.out.println("InherEx"+this.a + super.b);
		//부모 멤버를 this 또는 super로 부를 수 있다.
	}
	
	@Override//메소드 이름, 반환 타입, 변수 타입(int, String..), 변수의 개수 같아야 한다.
			  //접근 제어자는 달라질 수 있다.(public, static..), 커지는 개념으로는 오버라이드가 되지만, 작아지는 개념은 안된다.
			  //ex) public -> public(o), static(x) / private->public(o), private(o)
			  //오버라이드를 검증하는 기능을 한다.
	public void method() {
		System.out.println("Inher method");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InherEx inher = new InherEx();//default 생성자 존재
		//SuperClass inher = new SuperClass();
		//객체가 생성될때 생성자는 호출된다.
		//부모 생성자 호출된 뒤 자식 생성자가 호출된다.
		System.out.println(inher.a);
		System.out.println(inher.b);
		System.out.println(inher.c);//부모의 객체를 생성하면 자식의 멤버를 쓰지 못한다.
		inher.method();//메소드를 재정의하면 자식 클래스의 메소드가 호출된다.
	}

}

class SuperClass {
	
	int a = 10;
	String b = "B";
	
	public SuperClass() {
		System.out.println("SuperClass");

	}
	
	void method() {
		System.out.println("SuperClass method");
	}
	
}

interface B2 {
	
}

