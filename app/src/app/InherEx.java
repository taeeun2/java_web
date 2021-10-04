package app;

/*
 * ���(Inheritance)
	 - ����̶� �ڽ��� �θ� ������ �ִ� ����̳� �Ƿ��� �����޴´ٴ� �ǹ�.
	 - Ư��(�ڽ�)Ŭ������ �ٸ�(�θ�)Ŭ������ ������ �ִ� ��� ��������� ��� �޼ҵ带 ����� �� ����.
	 - ��� ���迡�� �ڽ�Ŭ������ ��ü�� �������� �� �θ� Ŭ������ ��ü�� �����Ǿ���.
	 - ��� ���� ǥ������ extends keyword�� �����.
	 - ��� ���� ���� super, ����, �θ� class�� sub, ����, �ڽ� class�� �����
	 - ����� ���信�� super�� this�� ������.
	 - �޼��带 ������ �� ����(method override).
	 - ���� ���(�ڹٿ����� ���� ��� x)
	 - extends �� implements�� �Բ� ����� �� ����.
 ����)
 	class A extends B{
 		���� ����;
 	}
 */



public class InherEx extends SuperClass implements B2{

	int c = 20;
	public InherEx() {
		super();//�̰��� �������ִ�.
		System.out.println("InherEx"+this.a + super.b);
		//�θ� ����� this �Ǵ� super�� �θ� �� �ִ�.
	}
	
	@Override//�޼ҵ� �̸�, ��ȯ Ÿ��, ���� Ÿ��(int, String..), ������ ���� ���ƾ� �Ѵ�.
			  //���� �����ڴ� �޶��� �� �ִ�.(public, static..), Ŀ���� �������δ� �������̵尡 ������, �۾����� ������ �ȵȴ�.
			  //ex) public -> public(o), static(x) / private->public(o), private(o)
			  //�������̵带 �����ϴ� ����� �Ѵ�.
	public void method() {
		System.out.println("Inher method");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InherEx inher = new InherEx();//default ������ ����
		//SuperClass inher = new SuperClass();
		//��ü�� �����ɶ� �����ڴ� ȣ��ȴ�.
		//�θ� ������ ȣ��� �� �ڽ� �����ڰ� ȣ��ȴ�.
		System.out.println(inher.a);
		System.out.println(inher.b);
		System.out.println(inher.c);//�θ��� ��ü�� �����ϸ� �ڽ��� ����� ���� ���Ѵ�.
		inher.method();//�޼ҵ带 �������ϸ� �ڽ� Ŭ������ �޼ҵ尡 ȣ��ȴ�.
	}

}

class SuperClass {
	
	int a = 10;
	String b = "B";
	
	public SuperClass() {
		System.out.println("SuperClass");

	}
	
	void method() {
		System.out.println("SuperClass method");
	}
	
}

interface B2 {
	
}

