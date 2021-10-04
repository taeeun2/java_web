package api;

public class StringEx {

	public static void main(String[] args) {
		//static에서는 super나 this를 쓸 수 없다.
		String a = "A";//하나의 객체를 공유한다.
		String b = "A";
		//메모리에 A객체 하나만 생성된다. -> 메모리 절약
		String c = new String("A");//별도의 A생성
		System.out.println(a == b);//a와 b가 가르키는 객체는 같다.
		System.out.println(a.equals(b));//문자 비교(내용 비교)
		System.out.println(a == c);//a와 c가 가르키는 객체는 다르다.
		
		Object o = "abc";//string 객체가 형변환되어 생성
		String s = "abc";
		String s2 = "abc";
		String s3 = null;
		System.out.println(o == s);//(o)
		System.out.println(o == s2);//(o)
		if(o instanceof String) {
			System.out.println("string instance");
		}
		String s4 = new String("abc");
		System.out.println(o.toString());
		System.out.println(o == s4);//(x)
		System.out.println(s == s4);//(x)
		System.out.println(o.equals(s4));//(o)
		System.out.println(s3 == s4);//(x)
	}

}
