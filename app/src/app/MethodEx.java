package app;

//메소드(Method)
/*
	 * 형식)
	 		-[접근 제어자][수정자][반환형] 메소드 명(인자들){
	 				실행 구문(구현);
	 		}
	 		
	 * 접근 제어자(Modifiers) - 생략 가능
	 	: private, default(friendly), protected, public
	 * 수정자 - 생략 가능
	 	: static, final, abstract, native ...	
	 * 반환형 (return type) - 생략 불가
	    - 자바 데이터 자료형(기본형, 참조형) 전부 사용할 수 있음
	    - void : 반환형이 없는 메소드 정의 시 사용
	 * 메소드 명 : 식별자로 임의의 이름 정의
	 * 인자(Arguments) : 매개 변수라고 하며 메소드 호출 시 데이터를 전달하기 위한 용도로 사용

   	ex1) public int method1(){ => 사용자 정의 메소드
   			실행 구문;
   			return 값(int);
   		 } 
   	ex2) void method2(int d){
   			실행 구문;
   			int dan = d;
   		 }
   
 */

public class MethodEx {

	static int method() {//static : 기계가 찾을 수 있는 곳
		return 10;
	}
	
	static void method2() {
		System.out.println("실행");
	}
	static void method3(int a, String s) {
		System.out.println("method3 : "+ a + ", " + s );
	}
	public static void main(String[] args) {
		
		int result = method();
		System.out.println(result);
		method2();
		method3(50,"abcd");
		
	}

}
