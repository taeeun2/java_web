package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOEx4 {
	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		//byte��Ʈ��->char��Ʈ��
		BufferedReader br = new BufferedReader(isr);
		String data = "";
		while(true) {
			System.out.print("���ڿ� �Է� : ");
			try {
				data = br.readLine();//���ڿ��� ó���ϰ� �����ش�.
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(data.equals("end")) {
				System.out.println("���α׷� ����");
				break;
			}
			System.out.println("�Էµ� �����ʹ� : "+data);
		}
	}
}
