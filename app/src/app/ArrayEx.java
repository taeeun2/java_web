package app;

import java.util.Scanner;

/*
 * �迭(array)
 * - ���� �ڷ����� �����͸� ���� �� �����ϱ� ���� �޸� ������ ����.
 * - ������ �޸� ������ index�� �̿��Ͽ� �� �����Ҹ� ������.
 * - �迭ũ��� length�� ����Ͽ� ����.
 * 
 * ǥ��)
 * int[] a = new int[2];
 * int[] b = {10,20};
 * int[] c = new int[]{10, 20};
 * 
*/
public class ArrayEx {

	public static void main(String[] args) {
		//ex1)
		int[] a = new int[2];//�ڵ� �ʱ�ȭ 0
		
		a[0] = 10;
		a[1] = 20;
		
		for(int i : a) {
			System.out.println(i);
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		//ex2)
		int[] b = {10,20};//������ ���ÿ� �ʱ�ȭ 
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
//			System.out.println("�� ���� ����Ͻðڽ��ϱ�? ");
//			dan[i] = scanner.nextInt();
//			for(int j = 1;j<10;j++) {
//				System.out.println(dan[i]+"*"+j+"="+(dan[i]*j));
//			}
//		}
//		
		for(int i : dan) {
			System.out.println("�� ���� ����Ͻðڽ��ϱ�? ");
			i = scanner.nextInt();
			for(int j = 1;j<10;j++) {
				System.out.println(i+"*"+j+"="+(i*j));
			}
		}
		
		
		
	}

}
