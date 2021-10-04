package api;

/*
 	기타제어자(수정자)
 	형식)
 	* final:
 		- class : 상속이 안됨
 		- method : 재사용이 안됨
 		- variable : 상수화
 	* static:
 		- 객체 생성 없이 사용 가능(정적 메모리에 생성)
 	* abstract :
 		- class : 추상 클래스
 		- method : 추상 메소드
 	
 	[수정자][접근지정자]...
 */

public final class StaticEx {

	public final int A = 10;//상수 표현
	public static int b = 20;//정적 메모리에 생성
	public final static int C = 30;//정적인 메모리에 상수를 고정적으로 생성
	
	public static void method() {
		System.out.println("method");
	}
	
	public static void main(String[] args) {

		StaticEx e = new StaticEx();
		System.out.println(e.A);
		System.out.println(new StaticEx().A);

		System.out.println(b);
		System.out.println(StaticEx.b);
		method();
	}

}
