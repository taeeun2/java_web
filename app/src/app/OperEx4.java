package app;

/*
 * 논리 연산자
 * | : or 연산자
 * & : and 연산자
 * || 
 * &&
 * 형식1 ) boolean result = 조건식 | 조건식2;
 * ex1-1) 
 * 		 참 | 거짓 => 참 : 첫번째가 참이더라도 뒤의 것을 연산한다.
 * ex1-2)
 * 		 거짓 | 참 => 참
 * ex1-3)
 * 		 참 | 참 => 참
 * ex1-4)
 * 		 거짓 | 거짓 => 거짓
 * 
 * 형식2 ) boolean result = 조건식 1|| 조건식2;
 * ex2-1) 
 * 		 참 || 거짓 => 참 : 첫번째가 참이면 뒤에 것을 연산하지 않는다.
 * ex2-2)
 * 		 거짓 || 참 => 참
 * ex2-3)
 * 		 참 || 참 => 참 
 * ex2-4)
 * 		 거짓 || 거짓 => 거짓
 *
 * 형식3 ) boolean result = 조건식1 & 조건식2;
 * ex3-1) 
 * 		 참 & 거짓 => 거짓 
 * ex3-2)
 * 		 거짓 & 참 => 거짓
 * ex3-3)
 * 		 참 & 참 => 참 
 * ex3-4)
 * 		 거짓 & 거짓 => 거짓
 *
 *
 * 형식4 ) boolean result = 조건식1 && 조건식2;
 * ex4-1) 
 * 		 참 && 거짓 => 거짓 
 * ex4-2)
 * 		 거짓 && 참 => 거짓 : 첫번째가 거짓이면 뒤의 것을 연산하지 않는다.
 * ex4-3)
 * 		 참 && 참 => 참 
 * ex4-4)
 * 		 거짓 && 거짓 => 거짓
 *
 *
 *
 */
public class OperEx4 {

	public static void main(String[] args) {
		
		boolean result = 3 < 5 | 2 > 5 ;
		System.out.println(result);
		
		result = 3 > 5 || 2 > 5 ;
		System.out.println(result);

		boolean a = true;
		boolean b = false;
		result = a||b;
		System.out.println(result);
		
		int sum = 0;
		a = true;
		result = a || 10 > (sum = 3+5); // 뒤에 것이 실행이 안됨
		System.out.println(sum);
		
		result = a | 10 > (sum = 3+5);// 뒤에 것이 실행이 됨
		System.out.println(sum);
		System.out.println(result);
		//////////////////////////////////////////////////
		int sum2 = 0;
		boolean a2 = false;
		result = a2 && 10 > (sum2 = 3+4);
		System.out.println(sum2);
		
		result = a2 & 10 > (sum2 = 3+4);
		System.out.println(sum2);
		System.out.println(result);

	}

}
