package api;

public class StringBufferEx {

	public static void main(String[] args) {
//		StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();

		sb.append("자바");
		sb.append("객체 언어");
		sb.append(" 입니다.");
		System.out.println("결과 : " + sb.toString());
	}

}
