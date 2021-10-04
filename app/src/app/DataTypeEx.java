package app;
/*
 자료형(Data Type)
 - 변수 또는 상수가 차지하는 메모리의 양(byte)과 종류를 의미한다.
 - 자바의 자료형은 크게 기본 자료형과 참조형으로 나눌 수 있다.
 1) 기본형
 	 (논리형)
 	 - boolean(true, false) : 8bit(1바이트)
 	 (정수)
 	 - byte : 8비트(1바이트)
 	 - short : 16비트
 	 - char : 16비트 - 문자
 	 - int : 32비트
 	 - long : 64비트
 	 (실수)
 	 - float : 32비트
 	 - double : 64비트
 2) 참조형
 		- 클래스(class)
 		- 배열(array)
 		- 인터페이스(interface)
 		- 열거(enum)
 */

public class DataTypeEx {
	public static void main(String args[]) {
		boolean bool = true;
		System.out.println(bool);
		byte byte1 = 10;
		System.out.println(byte1);
		short short1 = 20;
		System.out.println(short1);
		int int1 = 30;
		System.out.println(int1);
		long long1 = 40;
		System.out.println(long1);
		char char1 = 'A';
		System.out.println(char1);
		float float1 = 0.1f;
		System.out.println(float1);
		double double1 = 1.1d;
		System.out.println(double1);
	}
}
