package api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx8 {

	public static void main(String[] args) throws IOException{
		File file = new File("C:/work/IOtest.txt");
		FileOutputStream fos = new FileOutputStream(file);
		System.out.println("ют╥б : ");
		int output = 0;
		while(output != -1) {
			output = System.in.read();
			fos.write(output);
		}
		fos.close();
		

	}

}
