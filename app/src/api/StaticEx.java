package api;

/*
 	��Ÿ������(������)
 	����)
 	* final:
 		- class : ����� �ȵ�
 		- method : ������ �ȵ�
 		- variable : ���ȭ
 	* static:
 		- ��ü ���� ���� ��� ����(���� �޸𸮿� ����)
 	* abstract :
 		- class : �߻� Ŭ����
 		- method : �߻� �޼ҵ�
 	
 	[������][����������]...
 */

public final class StaticEx {

	public final int A = 10;//��� ǥ��
	public static int b = 20;//���� �޸𸮿� ����
	public final static int C = 30;//������ �޸𸮿� ����� ���������� ����
	
	public static void method() {
		System.out.println("method");
	}
	
	public static void main(String[] args) {

		StaticEx e = new StaticEx();
		System.out.println(e.A);
		System.out.println(new StaticEx().A);

		System.out.println(b);
		System.out.println(StaticEx.b);
		method();
	}

}
