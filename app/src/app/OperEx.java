package app;

/* ������
 * 
 * ��� : +, -, /, %, *
 * ���� : ++, --
 * �� : <, <=, >, >=, ==, !=. instanceof
 * ��Ʈ : &, |
 * �� : &&, ||
 * ���� : expr ? expr : expr
 * 
 */

/*
 * ������ ������
 * ������(���) ������
 * ǥ��)
 * 
 * 	+ => ���ϱ�
 *  - => ����
 *  * => ���ϱ�
 *  / => ������(��)
 *  % => ������
 */
public class OperEx {

	public static void main(String[] args) {
		int su = 10;
		System.out.println("su = " + su);
		
		int su1 = 10, su2 = 20;
		int result = 0;
		
		result = su1+su2;
		System.out.println("result = " + result);
		
		result = su1 - su2;
		System.out.println("result = "+result);
		
		result = su2 / su1;
		System.out.println("result = "+result);
		
		result = su2 % su1;
		System.out.println("result = "+result);
		
	}
}
