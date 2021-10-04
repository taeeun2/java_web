package app;

public class ShapeUser {

	public static void main(String[] args) {
		Shape[] shape = new Shape[3];
		shape[0] = new Circle(5);//�ڵ� ����ȯ(circle->shape)
		shape[1] = new Circle(7);
		shape[2] = new Rect(9,5);
		
		System.out.println("shape[0]'s area : " + shape[0].area());	//�������̵�� �޼ҵ�� �״�� ����� �� �ִ�.
		System.out.println("shape[1]'s area : " + shape[1].area());
		System.out.println("shape[2]'s area : " + shape[2].area());
		
		//���� 1) circumference ���
		System.out.println("shape[0]'s circumference : " + shape[0].circumference());
		System.out.println("shape[1]'s circumference : " + shape[1].circumference());
		System.out.println("shape[2]'s circumference : " + shape[2].circumference());
		//���� 2) shape[1] ������ �������� 3������ �����ؼ� ����� ����Ͻÿ�.
		Circle c = (Circle)shape[1];//���� ����ȯ(shape->circle)
		c.setRadius(3);
		
		((Circle)shape[1]).setRadius(4);//�ڽ� �޼ҵ带 �ҷ����� ���ؼ��� ����ȯ�� �ؾ��Ѵ�.
	
		
		System.out.println("shape[1]'s area : " + c.area());
		System.out.println("shape[1]'s circumference : " + c.circumference());
		
	}

}
