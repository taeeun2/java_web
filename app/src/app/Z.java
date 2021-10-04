package app;

class X{
	protected int i = 10;
	protected String msg = "I am a X.";
	public void print() {
		System.out.println(msg);
	}
	
	public void play() {
		System.out.println("Play.."+msg);
	}
}

class Y extends X{
	protected int i = 20;
	protected String msg = "I am an Y.";
	@Override
	public void print() {
		System.out.println(msg);
	}
	
}

public class Z extends Y{

	protected int i = 30;
	protected String msg = "I am a Z.";
	@Override
	public void print() {
		System.out.println(msg);
	}
	@Override
	public void play() {
		System.out.println("Play.."+msg);
	}
	public void doZ() {
		System.out.println("do something in Z.");
	}
	
	public void test(int i) {
		Z z = new Z();
		Y y = z;
		X x = y;
		
		//문제)
		z.print();//I am an Z. override되기때문에 z의 print메소드만 출력함
		y.print();// "
		x.print();// "
		
		super.print();//I am an Y.
		this.play();//Play..I am an Z.
		super.play();//Play..I am an X.(Y에 play()메소드 없음)

		//y.doZ();
		//super.super.print(); -> super을 두개 사용할 수 없다.
		System.out.println("\ni = "+i);//15
		System.out.println("this.i = "+this.i);//z의 i =>30
		System.out.println("super.i = "+super.i);//y의 i => 20
		System.out.println("y.i = "+y.i);//y의 i=>20
		System.out.println("x.i = "+x.i);//x의 i=>10
		System.out.println("((Y)this).i = "+((Y)this).i);//y의 i=>20, 명시적 형변환
		System.out.println("((X)this).i = "+((X)this).i);//x의 i=>10
		//super.super.i = 10;
		
		
	}
	
	public static void main(String[] args) {

		Z z = new Z();
		z.test(15);

	}

}

