package app;

//������ Ÿ�� �� ����ȯ(������, �����)
public class CastEx {

	public static void main(String[] args) {
		byte a = 10;
		int b = a;
		// byte -> int �� ��ȯ : ���� ��-> ū�� �̹Ƿ� ����
		
		int c = 10;
		byte d = (byte)c;// int(32bit)-> byte(8bit) : ������ �ս��� ���� �� �ִ�-> ����� ����ȯ �ʿ�
		
		byte byte1 = 127;
		short short1 = byte1;
		
		short short2 = 13;
		byte byte2 = (byte) short2;
		
	

	}

}
