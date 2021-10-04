package api;

public class StringLengthEx {

	public static void main(String[] args) {
		String ssn = "499023029323";
		int length = ssn.length();

		if(length == 14) {
			System.out.println("주민번호 자리수가 맞습니다.");
		}
		else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
	}

}
