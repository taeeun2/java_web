package app;

import java.util.Scanner;

/*
 * ���(���� ���ǹ�)
 * ǥ��)
 * 	if(���ǽ� 1){
 * 		���� ���� 1;}
 * 	else if(���ǽ� 2){
 * 		���� ���� 2; }
 *  else{
 * 	}
 *  .
 *  .
 *  .
 * 
 */
public class IfEx2 {

	public static void main(String[] args) {
		
		System.out.println("������ �Է��Ͻÿ� : ");
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
			System.out.println("�ٽ� �Է��ϼ���.");
		}

	}

}
