package api;

/*
 * Exception
 * Ű���� �Է�, ���� ó��, ��Ʈ�p ó��, DB ó�� �� �ܺο��� �۾��� �ϴ� ���
 * ����ġ ���� ������ �߻��� �� �����Ƿ� �ڹٿ����� �ݵ�� ����ó���� �ϵ��� �ϰ��ִ�.
 */
public class ExceptionEx {

	String str = "";
	public void foo(int i) {
		try {
			if(i==1)
				throw new Exception();//������ ���� �߻�
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
		//���� ���� => ��Ÿ�� exception
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
//			//���ܹ߻� ����
//			char c = (char)System.in.read();
//		}
//		catch(Exception e) {
//			//����ó�� ����
//			System.out.println("char������ �ƴմϴ�.");
//		}
//		finally {
//			//�ݵ�� �����ϴ� ����
//		}
	}

}
