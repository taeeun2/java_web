package api;

import java.util.regex.Pattern;

public class PatternEx {
	

	public static void main(String[] args) {
		/*
		 * 보기)
		 * (02|010) : 02 또는 010
		 * -		: -포함
		 * \d{3,4}  : 3자리 또는 4자리 숫자
		 * -		: -포함
		 */
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if(result)
			System.out.println("정규식과 일치합니다.");
		else
			System.out.println("정규식과 일치하지 않습니다.");
		/*
		 * \w : 한개 이상의 알파벳 또는 숫자
		 * @ : @포함
		 * \w+ : 한개 이상의 알파벳 또는 숫자
		 * \. : .
		 * (\.\w+)? : \.\w+이 없거나 한번 더 올 수 있음
		 */
		
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@naver.com";
		result = Pattern.matches(regExp, data);
		if(result)
			System.out.println("정규식과 일치합니다.");
		else
			System.out.println("정규식과 일치하지 않습니다.");
	}
	
	

}
