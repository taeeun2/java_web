package app;

public class BreakEx {

	public static void main(String[] args) {
		int i = 0;
		boolean result = true;
		
		do {
			i++;
			if(result) {
			System.out.println("실행 구문");
				if(i == 5) {
					result = false;
				}
				if(!result) {
					System.out.println("실행 구문을 종료합니다.");
					break;
				}
			}else {
					System.out.println("i = "+i);
				}
		}while(i<10);

	}

}
