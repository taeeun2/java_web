package api;

public class StringSplitEx {

	public static void main(String[] args) {

		String text = "홍길동&자바군,김자바,이자바-최자바";
		String[] names = text.split("&|,|-");
		for(String name : names) {
			System.out.println(name);
		}
		
	}

}
