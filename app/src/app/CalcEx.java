package app;

public class CalcEx {

	public int addition(int n1, int n2) {
		return n1+n2;
	}
	public int subtraction(int n1, int n2) {
		return n1-n2;
	}
	public int multiplication(int n1, int n2) {
		return n1*n2;
	}
	public int division(int n1, int n2) {
		return n1/n2;
	}
	public void result(char operator, int n1, int n2) {
		switch(operator) {
		case'+':System.out.println(addition(n1,n2));break;
		case'-':System.out.println(subtraction(n1,n2));break;
		case'*':System.out.println(multiplication(n1,n2));break;
		case'/':System.out.println(division(n1,n2));break;
		default:System.out.println("잘못된 입력입니다.");
		}
	}
	public static void main(String[] args) throws java.io.IOException {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		System.out.print("Operator(+,-,*,/) : ");
		char oper = (char)System.in.read();
		new CalcEx().result(oper,n1,n2);//객체 생성 후 사용
	}

}
