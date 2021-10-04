package api;

import java.util.regex.Pattern;

public class PatternEx {
	

	public static void main(String[] args) {
		/*
		 * ����)
		 * (02|010) : 02 �Ǵ� 010
		 * -		: -����
		 * \d{3,4}  : 3�ڸ� �Ǵ� 4�ڸ� ����
		 * -		: -����
		 */
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if(result)
			System.out.println("���Խİ� ��ġ�մϴ�.");
		else
			System.out.println("���Խİ� ��ġ���� �ʽ��ϴ�.");
		/*
		 * \w : �Ѱ� �̻��� ���ĺ� �Ǵ� ����
		 * @ : @����
		 * \w+ : �Ѱ� �̻��� ���ĺ� �Ǵ� ����
		 * \. : .
		 * (\.\w+)? : \.\w+�� ���ų� �ѹ� �� �� �� ����
		 */
		
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@naver.com";
		result = Pattern.matches(regExp, data);
		if(result)
			System.out.println("���Խİ� ��ġ�մϴ�.");
		else
			System.out.println("���Խİ� ��ġ���� �ʽ��ϴ�.");
	}
	
	

}
