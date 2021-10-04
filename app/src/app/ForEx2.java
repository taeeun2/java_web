package app;

/*
 * 표현)
 * for(변수 선언(초기화);조건식;증가 혹은 감소 수식){
 * 		실행 구문 1;
 * 		for(변수 선언(초기화); 조건식; 증가 혹은 감소 수식){
 * 			실행 구문 2;
 * 			}
 *  }
 */

public class ForEx2 {

	public static void main(String[] args) {
		
		//구구단 9단까지 출력하시오.
		for(int i = 1; i < 10; i++ ) {
			System.out.println(i+"단");
			for(int j = 1 ; j < 10 ; j++) {
				System.out.println(i+"*"+j+"="+(i*j));
			}
			System.out.println();
		}

		
		//구구단 출력 다른 방식
		for(int i = 1;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.print(j+"*"+i+"="+(j*i)+"\t");
			}
			System.out.println();
		}
		
		//별 출력하기
		for(int i = 1; i<6;i++) {
			for(int j = 1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		//별 반대로 출력하기
		
		for(int i = 1; i<6;i++) {
			for(int j = 1;j<=6-i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}

}
