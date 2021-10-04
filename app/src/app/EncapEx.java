package app;

/*
	 ���� ������(Access modifiers)
	 - ��ü�� ����� �����ϱ� ���� ������
	 ����)
	 - private : ���� ���� ö��, �ش� Ŭ������ ���� ����
	 - default(friendly) : �ش� ��Ű���� ���� ����
	 - protected : default�� ����, ����)����� �Ǿ������� ������ ����Ѵ�.
	 - public : ��� Ŭ������ ������ ����Ѵ�.
	 ����)
	 - Ŭ���� ǥ��
	 	[����������] class Ŭ������
	 - �޼��� ǥ��
	 	[����������][�ڷ���] �޼��� ��(���ڵ�){
	 	}
	 - ���� ǥ��
	 	[����������][�ڷ���] ������ = ������;
	 - ������ ǥ��
	 	[����������] Ŭ���� ��(���ڵ�){
	 	}
 */
public class EncapEx {

	public static void main(String[] args) {
		Encap encap = new Encap();
		System.out.println(encap.a);//���� ��Ű�� �ȿ� �ֱ� ������ a,b,c ��� ����
		System.out.println(encap.b);
		System.out.println(encap.c);
//		System.out.println(encap.d); ���� Ŭ���� �ȿ� ���� �ʱ� ������ �Ұ���

		encap.setD(100);
		System.out.println(encap.getD());
		
		
	}

}

class Encap{
	public int a = 10;
	protected int b = 20;
	int c = 30;
	private int d = 40;
	
	public void setD(int d) {//�ش� ������ ������ �� ���
		this.d = d;
	}

	public int getD() {//������ ������ �� ���
		return d;
	}

}
