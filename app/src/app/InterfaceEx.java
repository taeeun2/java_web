package app;

/*
 * 인터페이스(interface)
 	- 객체를 생성할 수 없음.
 	- class에서 상속 시 implements keyword를 사용
 	- 다중 상속이 가능함.
 	- interface에는 상수와 추상 메서드만이 존재함.
 	- interface 간의 상속 시에는 extends를 사용함.
 	- 일반적인 메서드를 가질 수 없음.
 	- 상속 시 interface에 있는 모든 메서드를 재정의하여 사용.
 	- interface에 정의된 메서드 중 하나라도 재정의하지 않는다면 
 	  abstract class로 정의할 수 있음
 	- (인터페이스는 데이터를 저장할 수 없기 때문에 인스턴스 또는 정적필드를 선언할 수 없음
 	     대신 상속 필드만 선언 가능)
 	  
 	  표현)
 	  interface A{
 	  		변수 : [final][static] -> 생략되어 있음.
 	  		ex) int A = 10;
 	  		
 	  		메서드 : [public][abstract] -> 생략되어 있음.
 	  		ex) void method();
 	  
 	  사용1)
 	  class C implements A{
 	  		인터페이스에 존재하는 메서드 재정의...(모든 메서드를 재정의해야 함)
 	  }
 	  
 	  사용2)
 	  abstract class B implements A{
 	  		추상 메서드 정의... (추상 메서드를 사용하여 재정의할 메서드만 재정의하여 사용)
 	  		일반적인 메서드 정의...
 	  }
	 사용3)
	 class D extends C implements A{}
	 class D extends C implements A, B, C...{}
 	  
 	  
 	 사용4)
 	 interface A extends B (B는 interface) 
 */

public class InterfaceEx extends AbstractC implements InterfaceA, InterfaceB{

	@Override
	public void methodA() {
		System.out.println("methodA");
	}
	@Override
	public String methodB() {
		return "methodB";
	}
	public static void main(String[] args) {
		InterfaceEx obj = new InterfaceEx();
		obj.methodA();//interface A의 메소드 재정의
		System.out.println(obj.methodB());//interface B의 메소드 재정의
		obj.methodC();//abstract class C의 메소드 호출
//		obj.A = 40; 상수는 변경 안됨
		System.out.println(obj.A);
		System.out.println(obj.B);
	}

}

interface InterfaceA{
	int A = 10;//상수필드
	void methodA();
}

interface InterfaceB{
	int B = 20;
	String methodB();
}

abstract class AbstractC{
	void methodC() {
		System.out.println("methodC");
	}
}