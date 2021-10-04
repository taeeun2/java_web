package app;

//switch ~ case문

/*
 *  표현)
 *  	switch (값){
 *  	case 값 1:
 *  		실행 구문 1;
 *  	case 값 2:
 *  		실행 구문 2;
 *  		break;(선택)
 *  	case 값 3:
 *  		실행 구문 3;
 *  		.
 *  		.
 *  		.
 *  	default: (else문과 같다)
 *  		실행 구문 4;
 *  		break;(선택)
 */

public class SwitchEx {

	public static void main(String[] args) {
		int val = 2;
		switch(val) {
			case 1:
				System.out.println("실행구문 1");
			case 2:
				System.out.println("실행구문 2");
				break;
			case 3:
				System.out.println("실행구문 3");
				break;
			case 4:
				System.out.println("실행구문 4");
			default:
				System.out.println("기본");
		}

	}

}
