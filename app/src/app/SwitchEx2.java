package app;

import java.io.IOException;

public class SwitchEx2 {

	public static void main(String[] args) throws IOException {
		System.out.println("Yes/No(Y,N) ?");
		char c = (char)System.in.read();
		
		switch(c) {
			case'y':
			
			case 'Y':
				System.out.println("Yes");
				break;
		
			case 'n':
			case 'N':
				System.out.println("No");
				break;
			default:
				System.out.println("Wrong answer");
		}
	}

}
