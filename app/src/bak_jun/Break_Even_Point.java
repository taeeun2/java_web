package bak_jun;

import java.util.Scanner;

public class Break_Even_Point {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
	
		if(b>=c)
			System.out.println(-1);
		else
			System.out.println(a/(c-b)+1);
		
	}

}
