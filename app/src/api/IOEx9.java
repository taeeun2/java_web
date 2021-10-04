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
		PrintWriter pw = new PrintWriter(bw,true);//moto flush �ڵ����� flush�� ���ش�.
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br =  new BufferedReader(isr);
		System.out.print("�Է� : ");
		String str = "";
		while(!str.equals("end")) {
			str = br.readLine();//���ڿ������� �о����, ���Ͱ�����
			pw.println(str);
		}
		br.close();
		pw.close();
		//��������) ���Ͽ� ��ϵ� ���ڵ����͸� ȭ�鿡 ����ϱ�
	
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr2 = new InputStreamReader(fis);
		BufferedReader br2 =  new BufferedReader(isr2);
		String data ="";
		while(!data.equals("end")) {
			data = br2.readLine();
			System.out.println(data);
		}
		
		//Ȱ�빮��) ��ũ�� ȸ�� �����͸� ���Ϸ� ����ϴ� ���α׷� �ۼ�
	}

}
