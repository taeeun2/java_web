package app;

public class MethodEx4 {

	static void method(int ...num) { //int a, int b, int c, int d ...
		for(int i:num)
			System.out.println(i);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method(1,3,5,2,33,6);
	}

}
