package api;

public class StringCharAtEx {

	public static void main(String[] args) {
		String ssn = "484839-2849382";
		char sex = ssn.charAt(7);
		switch(sex) {
			case'1':
			case'3':
				System.out.println("�����Դϴ�.");
				break;
			case'2':
			case'4':
				System.out.println("�����Դϴ�.");
				break;
			
		}
	}

}
