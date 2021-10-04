package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOEx4 {
	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		//byte스트림->char스트림
		BufferedReader br = new BufferedReader(isr);
		String data = "";
		while(true) {
			System.out.print("문자열 입력 : ");
			try {
				data = br.readLine();//문자열을 처리하고 내려준다.
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(data.equals("end")) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println("입력된 데이터는 : "+data);
		}
	}
}
