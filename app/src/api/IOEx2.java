package api;

import java.io.IOException;

public class IOEx2 {

	public static void main(String[] args) {
		int b = 0, count = 0;
		try {
			b = System.in.read();//���ڿ��� �ޱ�
			while(b!=(char)-1) {//ctrl+z
				System.out.println((char)b);//char�� ����ؾ� 
				count++;//�����Ʈ���� ����, ���Ͱ��� �ΰ� ����
				if(!(b==13||b==10)) {
				System.out.println("count : "+count);
				System.out.println("�Է� : "+b);
				}
				b = System.in.read();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n byte InputStream Test...total byte : " + count);
	}

}
