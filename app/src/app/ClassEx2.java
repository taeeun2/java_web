package app;

public class ClassEx2 {

	
	public static void main(String[] args) {

		
		SuperCar supercar = new SuperCar();
		supercar.display();
		supercar.speedUp();
		supercar.speedUp();
		supercar.display();
		supercar.engin();
		
	}

}

abstract class Car{
	int wheel;
	int speed;
	String name;
	
	public Car() {//�ʱ�ȭ
		wheel = 4;
		speed = 0;
		name = "Ƽ��";
	}
	
	public Car(String name) {//�� �̸� �ٲٱ�
		wheel = 4;
		speed = 0;
		this.name = name;
	}
	
	public abstract void engin();
	
	public void speedUp() {
		speed += 100;
	}
	public void display() {
		System.out.println("���̸� :"+name+", ����ӵ� : "+speed+", ������ : "+wheel);
	}
	
	public void display(String name, int speed, int wheel) {
		System.out.println("���̸� :"+name+", "
				+ "�ִ� �ӵ� : "+this.speed+", ������ : "+wheel);
	}
	
	
}

class SuperCar extends Car{
	
	public void engin() {
		System.out.println("�ο;ƾ�");
	}
	
	public SuperCar() {
		speed = 0;
		name = "���������";
		wheel = 4;
	}
	@Override
	public void speedUp() {
		speed+=1000;
	}
	
}