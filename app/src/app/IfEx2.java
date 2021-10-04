package app;

import java.util.Scanner;

/*
 * 제어문(다중 조건문)
 * 표현)
 * 	if(조건식 1){
 * 		실행 구문 1;}
 * 	else if(조건식 2){
 * 		실행 구문 2; }
 *  else{
 * 	}
 *  .
 *  .
 *  .
 * 
 */
public class IfEx2 {

	public static void main(String[] args) {
		
		System.out.println("점수를 입력하시오 : ");
		int score = new Scanner(System.in).nextInt();
		
		if(score > 0 && score <= 60) {
			System.out.println("C");
		}
		else if(score <= 80) {
			System.out.println("B");
		}
		else if(score <= 100){
			System.out.println("A");
		}
		else {
			System.out.println("다시 입력하세요.");
		}

	}

}
