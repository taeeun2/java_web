package app;

import java.util.Scanner;

/*
 * 배열(array)
 * - 같은 자료형의 데이터를 여러 개 저장하기 위한 메모리 공간을 말함.
 * - 생성된 메모리 공간에 index를 이용하여 각 기억장소를 구분함.
 * - 배열크기는 length를 사용하여 구함.
 * 
 * 표현)
 * int[] a = new int[2];
 * int[] b = {10,20};
 * int[] c = new int[]{10, 20};
 * 
*/
public class ArrayEx {

	public static void main(String[] args) {
		//ex1)
		int[] a = new int[2];//자동 초기화 0
		
		a[0] = 10;
		a[1] = 20;
		
		for(int i : a) {
			System.out.println(i);
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		//ex2)
		int[] b = {10,20};//생성된 동시에 초기화 
		for(int i : b) {
			System.out.println(i);
		}
		
		//ex3)
		int[] c = new int[]{10, 20};
		for(int i : c) {
			System.out.println(i);
		}
		
		System.out.println("////////////////");
		int[] dan = new int[3];
		Scanner scanner = new Scanner(System.in);
		
//		for(int i=0;i< dan.length;i++) {
//			System.out.println("몇 단을 출력하시겠습니까? ");
//			dan[i] = scanner.nextInt();
//			for(int j = 1;j<10;j++) {
//				System.out.println(dan[i]+"*"+j+"="+(dan[i]*j));
//			}
//		}
//		
		for(int i : dan) {
			System.out.println("몇 단을 출력하시겠습니까? ");
			i = scanner.nextInt();
			for(int j = 1;j<10;j++) {
				System.out.println(i+"*"+j+"="+(i*j));
			}
		}
		
		
		
	}

}
