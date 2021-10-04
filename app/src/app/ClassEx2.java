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
	
	public Car() {//초기화
		wheel = 4;
		speed = 0;
		name = "티코";
	}
	
	public Car(String name) {//차 이름 바꾸기
		wheel = 4;
		speed = 0;
		this.name = name;
	}
	
	public abstract void engin();
	
	public void speedUp() {
		speed += 100;
	}
	public void display() {
		System.out.println("차이름 :"+name+", 현재속도 : "+speed+", 바퀴수 : "+wheel);
	}
	
	public void display(String name, int speed, int wheel) {
		System.out.println("차이름 :"+name+", "
				+ "최대 속도 : "+this.speed+", 바퀴수 : "+wheel);
	}
	
	
}

class SuperCar extends Car{
	
	public void engin() {
		System.out.println("부와아앙");
	}
	
	public SuperCar() {
		speed = 0;
		name = "람보르기니";
		wheel = 4;
	}
	@Override
	public void speedUp() {
		speed+=1000;
	}
	
}