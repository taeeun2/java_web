package app;

/*
 * 추상(abstract)
 	- 객체의 모호함을 class로 표현하기 위함.
 * 특징
  	- class에 사용 시 추상 class의 의미(ex : abstract class).
  	- 일반 메서드와 추상 메서드 사용 가능함.//양면성 -> class, interface의 중간 성격
  	- 객체를 생성할 수 없음.
  	- 상속관계에서 재정의함.
  	- 내부 익명 클래스(무명 anonymous class)로 객체생성을 할 수 있음
  	-> 이름이 없이 클래스 내부에 클래스를 만들 수 있다.
  	- 추상 메소드는 구현하지 않고, 재정의(Override)하여 사용함.
  	- 반드시 재정의를 해줘야 한다!
  	- 상속 시 extends keyword를 사용함
  	
  	표현)
  		abstract class A{
  			int a;
  			ex) abstract void setA();->추상 메소드, 몸통 만들 수 없음
  				void setB(){}->일반 메소드, 몸톰 만들어야 함.
  	사용)
  		class B extends A{
  			super class의 추상 메서드 재정의
  		}
 */
public class AbstractEx extends Abs{//awt(gui)

	@Override
	public void methodB() {
		System.out.println("추상 메소드 오버라이드");
	}
	public static void main(String[] args) {

		AbstractEx obj = new AbstractEx();
		System.out.println(obj.a);
		obj.methodA();
		obj.methodB();
		
		new Abs() {//내부 익명 클래스 -> 짧게 표현할 수 있다.
			public void methodB() {
				
			}
		};
	}

}

abstract class Abs{
	int a =10;
	public void methodA() {
		System.out.println("일반적인 메소드 실행");
	}
	
	public abstract void methodB();
	
}
