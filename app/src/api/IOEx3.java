package api;

import java.io.IOException;

public class IOEx3 {

	public static void main(String[] args) {
		byte b[] = new byte[5]; //���ڸ� ���� �迭���� Ȯ��
		System.out.println("�Է� : ");
		char c = ' ';
		try {
			System.in.read(b, 0,5);//�迭, b[0]����, 5������
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("��� : ");
		System.out.write(b, 0, 5);

	}

}
