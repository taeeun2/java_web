package app;

public class ConstructorEx {

	
	int i;// ��������
	public ConstructorEx() {//�����ڸ� Ȱ���� ��� ���� �ʱ�ȭ, �����ε�
		this(100);//����� ã�ư��� �� �� ���, �����ڸ� �� �� ����ϰ� ���� �� 
		i = 50;//��� ���� �θ� �� ���.(this ���� ����)
		}
	
	public ConstructorEx(int i) {
		this("A");//�����ε� = ���� �̸����� �������� �����ڳ� �޼ҵ带 ����� ����
		System.out.println("i = "+this.i);
	}
	
	public ConstructorEx(String s) {
		System.out.println("s = "+s);
	}
	
	public static void main(String[] args) {
	
		ConstructorEx obj = new ConstructorEx();
		System.out.println(obj.i);
	}

}
