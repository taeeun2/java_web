package api;

/*
 	클래스처럼 보이게 하는 상수
 	서로 관련이 있는 상수들을 모아 심볼릭한 명칭의 집합으로 정의한 것
 	Enum클래스형을 기반으로 한 클래스형 선언
 	새로운 열거형을 선언하면, 내부적으로 Enum 클래스형 기반의 새로운 클래스형이 만들어짐.
 */
public class EnumEx {

	public static void main(String[] args) {
//		ex1)
//		String seoul = City.SEOUL;
//		System.out.println(seoul);
		
		City c1 = City.valueOf("서울");
		City[] arr = City.values();
		System.out.println(c1+"\n");
		for(City city : City.values()) {
			System.out.println(city);
		}
		
	
		
	}
// ex2	
	public enum City{
		서울, 부산, 대구, 광주, 대전
		//배열구조를 가짐.
	}

}

class City{
	public static final String SEOUL = "서울";
	public final static String BUSAN = "부산";
	public final static String DAEGU = "대구";
	public final static String GWANGJU = "광주";
	public final static String DAEJEON = "대전";

}