package app;

public class ConstructorEx {

	
	int i;// 전역변수
	public ConstructorEx() {//생성자를 활용해 멤버 변수 초기화, 오버로드
		this(100);//멤버를 찾아가게 할 때 사용, 생성자를 둘 다 사용하고 싶을 때 
		i = 50;//멤버 변수 부를 때 사용.(this 생략 가능)
		}
	
	public ConstructorEx(int i) {
		this("A");//오버로드 = 같은 이름으로 여러개의 생성자나 메소드를 만드는 개념
		System.out.println("i = "+this.i);
	}
	
	public ConstructorEx(String s) {
		System.out.println("s = "+s);
	}
	
	public static void main(String[] args) {
	
		ConstructorEx obj = new ConstructorEx();
		System.out.println(obj.i);
	}

}
