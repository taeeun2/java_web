package api;

public class ObjectEx {

	public static void main(String[] args) {
		Point obj = new Point();
		System.out.println("클래스 이름 : "+obj.getClass());
		System.out.println("해쉬 코드 : "+obj.hashCode());
		Point obj2= new Point();
		System.out.println("해쉬 코드 : "+obj2.hashCode());
		System.out.println("객체 비교 : "+obj.equals(obj2));//객체 비교
		System.out.println("객체 문자열 : "+obj.toString());


	}

}

class Point{
	
}
