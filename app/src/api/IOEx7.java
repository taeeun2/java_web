package api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IOEx7 {

	public static void main(String[] args) throws IOException{
		File file = new File("C:/work/IOtest2.txt");
		OutputStream fos = new FileOutputStream(file);//byte��Ʈ��
		String str = "ABC";
		byte[] data = str.getBytes();//���ڸ� ����Ʈ������ ����
		for(int i=0;i<data.length;i++) {
			fos.write(data[i]);//����Ʈ������ ����
		}
		fos.flush();//�ٿ������� �������� �ѷ��ִ� ����
		fos.close();
	}

}
