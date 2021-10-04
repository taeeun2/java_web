package app;

public class MethodEx3 {

	static void method(int dan1, int dan2) {
			
		for(int j=dan1;j<=dan2;j++) {
			for(int i=1;i<10;i++) {
				System.out.println(j+" * "+i+" = "+j*i);
			}	
			System.out.println();
		}
	}
	
	static void method2(int[] arr) {
		
		for(int i:arr) {
			for(int j=1;j<10;j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		//문제 1) dan1, dan2 args로 만들어 사용(method) 범위 사용
		//문제 2) 배열범위의 단 출력(int array[] = {2,5,7,3}
		int dan1 = Integer.parseInt(args[0]);
		int dan2 = Integer.parseInt(args[1]);
		method(dan1, dan2);
		
		System.out.println("////////////////////////");
		
		int array[] = {2,5,7,3};
		method2(array);
		
	}

}
