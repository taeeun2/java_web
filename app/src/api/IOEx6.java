package api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOEx6 {

	public static void main(String[] args) throws IOException{

		File file = new File("C:/work/IOtest.txt");
		InputStream is = new FileInputStream(file);
		int readByteNo;
		byte[] readBytes = new byte[3];
		String data = "";
		while(true) {
			readByteNo = is.read(readBytes);
			if(readByteNo == -1)//���̻� �о�� ���� ���� ��
				break;
			data += new String(readBytes, 0, readByteNo);//3���� �о���δ�.
			System.out.println(data+"///");
		}
		System.out.println(data);
		is.close();
		
	}

}
