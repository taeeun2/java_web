package api;

public class ObjectEx {

	public static void main(String[] args) {
		Point obj = new Point();
		System.out.println("Ŭ���� �̸� : "+obj.getClass());
		System.out.println("�ؽ� �ڵ� : "+obj.hashCode());
		Point obj2= new Point();
		System.out.println("�ؽ� �ڵ� : "+obj2.hashCode());
		System.out.println("��ü �� : "+obj.equals(obj2));//��ü ��
		System.out.println("��ü ���ڿ� : "+obj.toString());


	}

}

class Point{
	
}
