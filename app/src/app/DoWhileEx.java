package app;

import java.util.Scanner;

//�ݺ���(do~while��)
/*
 * ǥ��)
 * do{
 * 		���౸��;
 * } while(���ǽ�);
 */
public class DoWhileEx {

	public static void main(String[] args) {
		int cnt = 0;
		do {
			cnt++;
			System.out.print(cnt+"\t");//tap��ŭ ����� ���
		}while(cnt < 10);//��� �ѹ��� ����
		
		System.out.println("\n");
		
		// ����) ������ 7���� ����Ͻÿ�.
		System.out.println("�� ���� ����Ͻðڽ��ϱ�?");
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
