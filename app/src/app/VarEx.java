package app;

public class VarEx {

	public static void main(String[] args) {
		//변수와 상수
		int su;
		su = 10;
		System.out.println(su);
		su = 20;
		System.out.println(su);
		
		String str = "HelloJava";
		System.out.println(str);
		str = "문자열";
		System.out.println(str);
		
		//자바에서 상수를 표현할 때 final 키워드를 사용
		final int ABC = 10;//상수(변경되지 않아야 할 데이터, 보통 대문자로 씀)
		//ABC = 20; -> 에러!
		
		System.out.println(ABC);
		
		
		
		
	}

}
