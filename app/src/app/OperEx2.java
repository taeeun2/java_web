package app;
/*
 * 비교 연산자
 * 
 * <
 * >
 * <=
 * >=
 * ==
 * !=
 * !
 * instanceof
 * 
 * 
 */
public class OperEx2 {

	public static void main(String[] args) {
		System.out.println(5<10);
		System.out.println(5>10);
		System.out.println(5<=5);
		System.out.println(!(5!=10));
		System.out.println((3<5)+" "+(4>5));

		int x = 30;
		int y = 20;
		boolean result = x<y;
		System.out.println("결과 1 : "+result);
		
		result = x>y;
		System.out.println("결과 2 : "+result);
		
		result = x!=y;
		System.out.println("결과 3 : "+result);
		
		result = x==y;
		System.out.println("결과 4 "+result);
		
		result = !result;
		System.out.println("결과 5 "+result);
		
		
		
	}

}
