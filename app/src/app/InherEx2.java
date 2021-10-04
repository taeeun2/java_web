package app;

class C{//최상위 클래스
	int num = 10;//은닉변수
	String msg = "msg...";
	public C() {
		System.out.println("C");
	}
	
	public void method() {
		System.out.println("method"+num);
	}
	
	public void method_C() {
		System.out.println("method_C "+msg);
	}
}
class B extends C{
	
	int num = 50;

	public B() {
		super();
		System.out.println("B");
	}
	@Override
	public void method() {
		super.method_C();
		this.method_C();
		System.out.println("method"+num);
	}
	public void method_B() {
		System.out.println("method_B "+msg);
	}
}
class A extends B{
	public A() {
		//super().super();
		System.out.println("A");
	}
	public void method_A() {
		System.out.println("method_A "+msg);
	}
	@Override
	public void method() {
		System.out.println("method "+msg);
		
	}
}

public class InherEx2 {

	public static void main(String[] args) {
		A a = new A();//C->B->A 순서로 출력
		B b = a; //형변환, B>A이기 때문에 A->B로 변환할 수 있다.
				 //상속관계가 없다면 형변환을 할 수 없다.
		C c = b; //B->C로 변환할 수 있다.

		System.out.println(c.num);//C클래스의 num 출력
		
		A z = (A)c; //C->A로 변환할 때는 강제적으로 형변환해줘야한다.
		A y = (A)b; //B->A
		B h = (B)c; //C->B
		
		Object o1 = a;//오브젝트는 모든 클래스의 최상위 클래스이다.
		Object o2 = b;
		Object o3 = c;
		
		int[] arr = new int[2];
		Object[] obj_arr = new Object[2];//다양한 타입의 데이터들을 넣을 수 있다.
		//다형성
		
		arr[0] = 10;
		obj_arr[0] = a;
		
		A k = (A)obj_arr[0];//사용할 때는 그 타입으로 분류를 해야 한다.
		
		a.method();//A클래스의 method 함수 출력
		a.method_A();//method_A 출력
		a.method_C();//C클래스의 method_C출력
	
		System.out.println(a.num);//클래스 B의 num출력

	}

}
