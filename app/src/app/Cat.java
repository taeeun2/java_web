package app;

public class Cat extends AnimalEx{

	public Cat() {
		age = 10;
		name = "����";
	}
	
	@Override
	public void bark() {
		System.out.println("�߿�");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		cat.bark();
		System.out.println("���� : "+cat.age+ "\n�̸� : "+cat.name);
		
	}

}
