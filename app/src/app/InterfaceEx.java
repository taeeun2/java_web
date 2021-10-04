package app;

/*
 * �������̽�(interface)
 	- ��ü�� ������ �� ����.
 	- class���� ��� �� implements keyword�� ���
 	- ���� ����� ������.
 	- interface���� ����� �߻� �޼��常�� ������.
 	- interface ���� ��� �ÿ��� extends�� �����.
 	- �Ϲ����� �޼��带 ���� �� ����.
 	- ��� �� interface�� �ִ� ��� �޼��带 �������Ͽ� ���.
 	- interface�� ���ǵ� �޼��� �� �ϳ��� ���������� �ʴ´ٸ� 
 	  abstract class�� ������ �� ����
 	- (�������̽��� �����͸� ������ �� ���� ������ �ν��Ͻ� �Ǵ� �����ʵ带 ������ �� ����
 	     ��� ��� �ʵ常 ���� ����)
 	  
 	  ǥ��)
 	  interface A{
 	  		���� : [final][static] -> �����Ǿ� ����.
 	  		ex) int A = 10;
 	  		
 	  		�޼��� : [public][abstract] -> �����Ǿ� ����.
 	  		ex) void method();
 	  
 	  ���1)
 	  class C implements A{
 	  		�������̽��� �����ϴ� �޼��� ������...(��� �޼��带 �������ؾ� ��)
 	  }
 	  
 	  ���2)
 	  abstract class B implements A{
 	  		�߻� �޼��� ����... (�߻� �޼��带 ����Ͽ� �������� �޼��常 �������Ͽ� ���)
 	  		�Ϲ����� �޼��� ����...
 	  }
	 ���3)
	 class D extends C implements A{}
	 class D extends C implements A, B, C...{}
 	  
 	  
 	 ���4)
 	 interface A extends B (B�� interface) 
 */

public class InterfaceEx extends AbstractC implements InterfaceA, InterfaceB{

	@Override
	public void methodA() {
		System.out.println("methodA");
	}
	@Override
	public String methodB() {
		return "methodB";
	}
	public static void main(String[] args) {
		InterfaceEx obj = new InterfaceEx();
		obj.methodA();//interface A�� �޼ҵ� ������
		System.out.println(obj.methodB());//interface B�� �޼ҵ� ������
		obj.methodC();//abstract class C�� �޼ҵ� ȣ��
//		obj.A = 40; ����� ���� �ȵ�
		System.out.println(obj.A);
		System.out.println(obj.B);
	}

}

interface InterfaceA{
	int A = 10;//����ʵ�
	void methodA();
}

interface InterfaceB{
	int B = 20;
	String methodB();
}

abstract class AbstractC{
	void methodC() {
		System.out.println("methodC");
	}
}