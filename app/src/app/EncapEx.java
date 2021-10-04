package app;

/*
	 접근 제어자(Access modifiers)
	 - 객체의 사용을 제어하기 위한 제어자
	 종류)
	 - private : 가장 보안 철저, 해당 클래스만 접근 가능
	 - default(friendly) : 해당 패키지만 접근 가능
	 - protected : default와 동일, 예외)상속이 되어있으면 접근을 허용한다.
	 - public : 모든 클래스의 접근을 허용한다.
	 형식)
	 - 클래스 표현
	 	[접근지정자] class 클래스명
	 - 메서드 표현
	 	[접근지정자][자료형] 메서드 명(인자들){
	 	}
	 - 변수 표현
	 	[접근지정자][자료형] 변수명 = 데이터;
	 - 생성자 표현
	 	[접근지정자] 클래스 명(인자들){
	 	}
 */
public class EncapEx {

	public static void main(String[] args) {
		Encap encap = new Encap();
		System.out.println(encap.a);//같은 패키지 안에 있기 때문에 a,b,c 모두 가능
		System.out.println(encap.b);
		System.out.println(encap.c);
//		System.out.println(encap.d); 같은 클래스 안에 있지 않기 때문에 불가능

		encap.setD(100);
		System.out.println(encap.getD());
		
		
	}

}

class Encap{
	public int a = 10;
	protected int b = 20;
	int c = 30;
	private int d = 40;
	
	public void setD(int d) {//해당 정보를 수정할 때 사용
		this.d = d;
	}

	public int getD() {//정보를 가져올 때 사용
		return d;
	}

}
