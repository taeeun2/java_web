package api;

public class StringSplitEx {

	public static void main(String[] args) {

		String text = "ȫ�浿&�ڹٱ�,���ڹ�,���ڹ�-���ڹ�";
		String[] names = text.split("&|,|-");
		for(String name : names) {
			System.out.println(name);
		}
		
	}

}
