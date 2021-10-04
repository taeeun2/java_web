package api;

/*
 * Exception
 * 키보드 입력, 파일 처리, 네트웤 처리, DB 처리 등 외부와의 작업을 하는 경우
 * 예의치 못한 에러가 발생할 수 있으므로 자바에서는 반드시 예외처리를 하도록 하고있다.
 */
public class ExceptionEx {

	String str = "";
	public void foo(int i) {
		try {
			if(i==1)
				throw new Exception();//고의적 예외 발생
			str+="1";
		}catch(Exception e) {
			str+="2";
			return;
		}
		finally {
			str+="3";
		}
		str+="4";
	}
	
	public static void main(String[] args){
		
		ExceptionEx e = new ExceptionEx();
		e.foo(0);
		e.foo(1);
		System.out.println(e.str);
		//실행 에러 => 런타임 exception
//		//ex1)
//		int[] arr = new int[1];
//		System.out.println(arr[1]);
//		//ex2)
//		String str = null;
//		System.out.println(str.charAt(0));
//		//ex3)
//		String str = "A";
//		Object member = str;
//		Member2 m = (Member2) member;
		
//		try {
//			//예외발생 지역
//			char c = (char)System.in.read();
//		}
//		catch(Exception e) {
//			//예외처리 지역
//			System.out.println("char형식이 아닙니다.");
//		}
//		finally {
//			//반드시 실행하는 지역
//		}
	}

}
