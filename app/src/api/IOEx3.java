package api;

import java.io.IOException;

public class IOEx3 {

	public static void main(String[] args) {
		byte b[] = new byte[5]; //문자를 담을 배열공간 확보
		System.out.println("입력 : ");
		char c = ' ';
		try {
			System.in.read(b, 0,5);//배열, b[0]부터, 5개까지
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("출력 : ");
		System.out.write(b, 0, 5);

	}

}
