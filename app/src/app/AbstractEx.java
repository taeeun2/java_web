package app;

/*
 * �߻�(abstract)
 	- ��ü�� ��ȣ���� class�� ǥ���ϱ� ����.
 * Ư¡
  	- class�� ��� �� �߻� class�� �ǹ�(ex : abstract class).
  	- �Ϲ� �޼���� �߻� �޼��� ��� ������.//��鼺 -> class, interface�� �߰� ����
  	- ��ü�� ������ �� ����.
  	- ��Ӱ��迡�� ��������.
  	- ���� �͸� Ŭ����(���� anonymous class)�� ��ü������ �� �� ����
  	-> �̸��� ���� Ŭ���� ���ο� Ŭ������ ���� �� �ִ�.
  	- �߻� �޼ҵ�� �������� �ʰ�, ������(Override)�Ͽ� �����.
  	- �ݵ�� �����Ǹ� ����� �Ѵ�!
  	- ��� �� extends keyword�� �����
  	
  	ǥ��)
  		abstract class A{
  			int a;
  			ex) abstract void setA();->�߻� �޼ҵ�, ���� ���� �� ����
  				void setB(){}->�Ϲ� �޼ҵ�, ���� ������ ��.
  	���)
  		class B extends A{
  			super class�� �߻� �޼��� ������
  		}
 */
public class AbstractEx extends Abs{//awt(gui)

	@Override
	public void methodB() {
		System.out.println("�߻� �޼ҵ� �������̵�");
	}
	public static void main(String[] args) {

		AbstractEx obj = new AbstractEx();
		System.out.println(obj.a);
		obj.methodA();
		obj.methodB();
		
		new Abs() {//���� �͸� Ŭ���� -> ª�� ǥ���� �� �ִ�.
			public void methodB() {
				
			}
		};
	}

}

abstract class Abs{
	int a =10;
	public void methodA() {
		System.out.println("�Ϲ����� �޼ҵ� ����");
	}
	
	public abstract void methodB();
	
}
