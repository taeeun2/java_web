package api;

import java.io.IOException;

public class IOEx2 {

	public static void main(String[] args) {
		int b = 0, count = 0;
		try {
			b = System.in.read();//문자열로 받기
			while(b!=(char)-1) {//ctrl+z
				System.out.println((char)b);//char만 출력해야 
				count++;//몇바이트인지 센다, 엔터값이 두개 적용
				if(!(b==13||b==10)) {
				System.out.println("count : "+count);
				System.out.println("입력 : "+b);
				}
				b = System.in.read();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n byte InputStream Test...total byte : " + count);
	}

}
