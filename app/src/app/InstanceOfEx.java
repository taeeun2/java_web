package app;

public class InstanceOfEx {

	public static void main(String[] args) {
		Child child = new Child();
		if(child instanceof InterfaceZ) {//child가 InterfaceA를 대신할 수 있다.
			System.out.println("child is instance of Interface");
		}
		if(child instanceof Object) {//child가 InterfaceA를 대신할 수 있다.
			System.out.println("child is instance of Object");
		}
		if(child instanceof Parent) {//child가 InterfaceA를 대신할 수 있다.
			System.out.println("child is instance of Parent");
		}
		if(child instanceof Child) {//child가 InterfaceA를 대신할 수 있다.
			System.out.println("child is instance of Child");
		}

	}

}

interface InterfaceZ{
	
}
class Parent implements InterfaceZ{
	
}
class Child extends Parent{
	
}