package app;

public class ArgsEx {

	public static void main(String[] args) {
	
		String str = args[0];
		int su = Integer.parseInt(str);//문자열을 정수로 변환하는 함수
		//문자열이 숫자여야 가능
		boolean result = su%2==0;
		
		if(result)
			System.out.println("짝수 입니다.");
		else
			System.out.println("홀수 입니다.");
		
		
		
	}

}
