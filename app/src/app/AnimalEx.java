package app;

public abstract class AnimalEx {

	int age;
	String name;
//	public AnimalEx() {
//		this.age = 0;
//		this.name = "동물";
//	}
	public abstract void bark();//추상 메소드, 구현 x
	
//	public void bark(String sound) {
//		System.out.println(sound);
//	}
//	
//	public AnimalEx(int age, String name) {
//		this.age = age;
//		this.name = name;
//	}
	
	public void display() {
		System.out.println("이름 : "+name+"\n"+"나이 : "+age);
	}
//	
//	public static void main(String[] args) {
//		//AnimalEx animal = new AnimalEx(); ->객체를 생성할 수 없다.
//	
//	}


}
