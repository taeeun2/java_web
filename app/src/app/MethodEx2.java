package app;

public class MethodEx2 {

	static void method1() {
		int sum = 0;
		for(int i=1;i<=10;i++)
			sum+=i;
		
		System.out.println(sum);
	}
	
	
	static int method2(int a, int b) {
		int sum = 0;
		for(int i=a;i<=b;i++)
			sum+=i;
		return sum;
	}
	
	
	public static void main(String[] args) {
		// 문제 1~10 범위의 합을 출력하시오.(Method 사용)
		method1();
		System.out.println(method2(1,10));

	}

}
