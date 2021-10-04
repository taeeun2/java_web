package app;

class C{//�ֻ��� Ŭ����
	int num = 10;//���к���
	String msg = "msg...";
	public C() {
		System.out.println("C");
	}
	
	public void method() {
		System.out.println("method"+num);
	}
	
	public void method_C() {
		System.out.println("method_C "+msg);
	}
}
class B extends C{
	
	int num = 50;

	public B() {
		super();
		System.out.println("B");
	}
	@Override
	public void method() {
		super.method_C();
		this.method_C();
		System.out.println("method"+num);
	}
	public void method_B() {
		System.out.println("method_B "+msg);
	}
}
class A extends B{
	public A() {
		//super().super();
		System.out.println("A");
	}
	public void method_A() {
		System.out.println("method_A "+msg);
	}
	@Override
	public void method() {
		System.out.println("method "+msg);
		
	}
}

public class InherEx2 {

	public static void main(String[] args) {
		A a = new A();//C->B->A ������ ���
		B b = a; //����ȯ, B>A�̱� ������ A->B�� ��ȯ�� �� �ִ�.
				 //��Ӱ��谡 ���ٸ� ����ȯ�� �� �� ����.
		C c = b; //B->C�� ��ȯ�� �� �ִ�.

		System.out.println(c.num);//CŬ������ num ���
		
		A z = (A)c; //C->A�� ��ȯ�� ���� ���������� ����ȯ������Ѵ�.
		A y = (A)b; //B->A
		B h = (B)c; //C->B
		
		Object o1 = a;//������Ʈ�� ��� Ŭ������ �ֻ��� Ŭ�����̴�.
		Object o2 = b;
		Object o3 = c;
		
		int[] arr = new int[2];
		Object[] obj_arr = new Object[2];//�پ��� Ÿ���� �����͵��� ���� �� �ִ�.
		//������
		
		arr[0] = 10;
		obj_arr[0] = a;
		
		A k = (A)obj_arr[0];//����� ���� �� Ÿ������ �з��� �ؾ� �Ѵ�.
		
		a.method();//AŬ������ method �Լ� ���
		a.method_A();//method_A ���
		a.method_C();//CŬ������ method_C���
	
		System.out.println(a.num);//Ŭ���� B�� num���

	}

}
