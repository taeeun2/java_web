package api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOEx10 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:/work/IOtest.txt");
		FileReader fr = new FileReader(file);
		BufferedReader bw = new BufferedReader(fr);
		String str;
		while(bw.ready()) {
			str = bw.readLine();
			System.out.println(str);
		}
		bw.close();
		
	}

}
