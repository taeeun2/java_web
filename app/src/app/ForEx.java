package app;

//반복문(for문)
/*
 * 표현)
 * for(변수 선언(초기화); 조건식; 증가 혹은 감소 수식){
 * 		실행 구문;
 * }
 * 
 */
public class ForEx {

	public static void main(String[] args) {
		
		int i=0;
		for(;i<10;i++) {
			System.out.println(i);
		}
		// 문제 1) 1~100까지의 합을 구하시오.
		
		int sum = 0;
		for(int j = 1;j<=100;j++) {
			sum+=j;
		}
		
		System.out.println(sum);
		
		//문제 2) 1~100까지 짝수에 합 출력
		int sum2 = 0;
		for(int j = 2;j<=100;j+=2) {
			sum2+=j;
		}
		
		System.out.println(sum2);
		
		sum = 0;
		for(int k = 1; k<=100;k++) {
			if(k%2==0)
				sum+=k;
		}
		System.out.println(sum);
		
		//문제 3) 1~100까지 홀수에 합 출력
		int sum3 = 0;
		for(int j = 1;j<=100;j+=2) {
			sum3+=j;
		}
				
		System.out.println(sum3);
				

	}

}
