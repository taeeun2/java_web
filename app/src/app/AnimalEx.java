package app;

public abstract class AnimalEx {

	int age;
	String name;
//	public AnimalEx() {
//		this.age = 0;
//		this.name = "����";
//	}
	public abstract void bark();//�߻� �޼ҵ�, ���� x
	
//	public void bark(String sound) {
//		System.out.println(sound);
//	}
//	
//	public AnimalEx(int age, String name) {
//		this.age = age;
//		this.name = name;
//	}
	
	public void display() {
		System.out.println("�̸� : "+name+"\n"+"���� : "+age);
	}
//	
//	public static void main(String[] args) {
//		//AnimalEx animal = new AnimalEx(); ->��ü�� ������ �� ����.
//	
//	}


}
