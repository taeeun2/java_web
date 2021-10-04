package api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IOEx7 {

	public static void main(String[] args) throws IOException{
		File file = new File("C:/work/IOtest2.txt");
		OutputStream fos = new FileOutputStream(file);//byte스트림
		String str = "ABC";
		byte[] data = str.getBytes();//문자를 바이트단위로 저장
		for(int i=0;i<data.length;i++) {
			fos.write(data[i]);//바이트단위로 쓰기
		}
		fos.flush();//근원지에서 목적지로 뿌려주는 역할
		fos.close();
	}

}
