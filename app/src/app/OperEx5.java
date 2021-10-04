package app;

/*
 * 연산 후 대입 연산자
 * 
 * 형식)
 * 	 	+=
 * 		-=
 * 		*=
 * 		/=
 * 		%=
 * 		ex)
 * 			int su = 5;
 * 			su += 10; -> su = su + 10;
 * 			su %= 10; -> su = su % 10;
 * 
 */

public class OperEx5 {

	public static void main(String[] args) {
		int su1 = 10, su2 = 20, sum = 0;
		sum = su1 + su2;//30
		sum+=10;//40
		System.out.println("30 + 10 = " + sum);
		
		sum/=4;
		System.out.println("40 / 4 = " + sum);
		
		sum*=2;
		System.out.println("10 * 2 = " + sum);
		
		sum%=3;
		System.out.println("20 % 3 = " + sum);

	}

}
