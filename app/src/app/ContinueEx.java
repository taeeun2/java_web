package app;

public class ContinueEx {

	public static void main(String[] args) {
		int k = 0;
		for(int i =0; i < 10; i++) {
			System.out.println("반복 실행문");
			k++;
			if(k > 4) {
				continue;
			}
			System.out.println("반복 실행 제한");
		}
	}

}
