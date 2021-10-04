package app;

//데이터 타입 및 형변환(묵시적, 명시적)
public class CastEx {

	public static void main(String[] args) {
		byte a = 10;
		int b = a;
		// byte -> int 형 변환 : 작은 쪽-> 큰쪽 이므로 가능
		
		int c = 10;
		byte d = (byte)c;// int(32bit)-> byte(8bit) : 데이터 손실이 있을 수 있다-> 명시적 형변환 필요
		
		byte byte1 = 127;
		short short1 = byte1;
		
		short short2 = 13;
		byte byte2 = (byte) short2;
		
	

	}

}
