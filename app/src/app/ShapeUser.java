package app;

public class ShapeUser {

	public static void main(String[] args) {
		Shape[] shape = new Shape[3];
		shape[0] = new Circle(5);//자동 형변환(circle->shape)
		shape[1] = new Circle(7);
		shape[2] = new Rect(9,5);
		
		System.out.println("shape[0]'s area : " + shape[0].area());	//오버라이드된 메소드는 그대로 사용할 수 있다.
		System.out.println("shape[1]'s area : " + shape[1].area());
		System.out.println("shape[2]'s area : " + shape[2].area());
		
		//문제 1) circumference 출력
		System.out.println("shape[0]'s circumference : " + shape[0].circumference());
		System.out.println("shape[1]'s circumference : " + shape[1].circumference());
		System.out.println("shape[2]'s circumference : " + shape[2].circumference());
		//문제 2) shape[1] 도형의 반지름을 3값으로 변경해서 결과를 출력하시오.
		Circle c = (Circle)shape[1];//강제 형변환(shape->circle)
		c.setRadius(3);
		
		((Circle)shape[1]).setRadius(4);//자식 메소드를 불러오기 위해서는 형변환을 해야한다.
	
		
		System.out.println("shape[1]'s area : " + c.area());
		System.out.println("shape[1]'s circumference : " + c.circumference());
		
	}

}
