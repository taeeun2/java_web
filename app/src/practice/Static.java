package practice;

public class Static {
	static double contry = 3.14;
	int money = 4000;
	final int A = 40;
	static final double PI = 3.1432;//���
	 static void main(String[] args) {
		contry = 4;//���� �ʵ�
		Static a = new Static();
		a.money = 3000;//�ν��Ͻ� �ʵ� -> ��ü ��������� ��
		//���� : �ν��Ͻ� �ʵ� -> ��ü���� �ٸ� ������
		//     ���� �ʵ�-> ���� ������
	//	A = 50; -> final �����ʹ� ������ �� ����.
	}
}
