package app;

import java.util.Scanner;

//반복문(do~while문)
/*
 * 표현)
 * do{
 * 		실행구문;
 * } while(조건식);
 */
public class DoWhileEx {

	public static void main(String[] args) {
		int cnt = 0;
		do {
			cnt++;
			System.out.print(cnt+"\t");//tap만큼 띄워서 출력
		}while(cnt < 10);//적어도 한번은 실행
		
		System.out.println("\n");
		
		// 문제) 구구단 7단을 출력하시오.
		System.out.println("몇 단을 출력하시겠습니까?");
		int num = new Scanner(System.in).nextInt();
		int cnt2 = 1;
		
		while(cnt2 < 10) {
			System.out.println(num + "*" + cnt2 + "=" + num*cnt2);
			cnt2++;
		}
		
		System.out.println("////////////////////");
		
		int cnt3 = 0;
		do {
			cnt3++;
			System.out.println(num + "*" + cnt3 + "=" + num*cnt3);
		
		}while(cnt3<9);
		
		
		
		
		

	}

}
