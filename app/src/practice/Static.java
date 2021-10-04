package practice;

public class Static {
	static double contry = 3.14;
	int money = 4000;
	final int A = 40;
	static final double PI = 3.1432;//상수
	 static void main(String[] args) {
		contry = 4;//정적 필드
		Static a = new Static();
		a.money = 3000;//인스턴스 필드 -> 객체 생성해줘야 함
		//이유 : 인스턴스 필드 -> 객체마다 다른 데이터
		//     정적 필드-> 공용 데이터
	//	A = 50; -> final 데이터는 변경할 수 없음.
	}
}
