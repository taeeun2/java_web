package app;

//향상된 for문
/*
 * for(변수 선언 : 값들){
 * 		반복 실행 구문
 * }
 */

public class ForEx3 {

	public static void main(String[] args) {//args 매개변수
		
		//Run Configurations -> Arguments -> 입력 ex) a b c
		//한 칸 띄우고 값 입력
		
		
		for(String s : args) {//값들("a","b",...)
			System.out.println(s);
		}
	}

}
