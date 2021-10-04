package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOEx9 {

	public static void main(String[] args) throws IOException{
		File file = new File("C:/work/IOtest.txt");
		FileWriter fwriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fwriter);
		PrintWriter pw = new PrintWriter(bw,true);//moto flush 자동으로 flush를 해준다.
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br =  new BufferedReader(isr);
		System.out.print("입력 : ");
		String str = "";
		while(!str.equals("end")) {
			str = br.readLine();//문자열단위로 읽어들임, 엔터값까지
			pw.println(str);
		}
		br.close();
		pw.close();
		//연습문제) 파일에 기록된 문자데이터를 화면에 출력하기
	
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr2 = new InputStreamReader(fis);
		BufferedReader br2 =  new BufferedReader(isr2);
		String data ="";
		while(!data.equals("end")) {
			data = br2.readLine();
			System.out.println(data);
		}
		
		//활용문제) 뱅크에 회원 데이터를 파일로 기록하는 프로그램 작성
	}

}
