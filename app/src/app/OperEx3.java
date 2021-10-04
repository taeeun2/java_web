package app;

/*
 * 삼항 연산자
 * - 형식)
 * 데이터형 변수 = 조건식 ? 값1 : 값2;
 */
public class OperEx3 {

	public static void main(String[] args) {
		int a = 3 < 5 ? 10 :20;
		System.out.println(a);
		
		String result = 10>20 ? "참" : "거짓";
		System.out.println("결과 : " + result);
		
	}

}
