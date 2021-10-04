package app;

public class Cat extends AnimalEx{

	public Cat() {
		age = 10;
		name = "나비";
	}
	
	@Override
	public void bark() {
		System.out.println("야옹");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		cat.bark();
		System.out.println("나이 : "+cat.age+ "\n이름 : "+cat.name);
		
	}

}
