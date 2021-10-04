package app;

/*
 * �� ������
 * | : or ������
 * & : and ������
 * || 
 * &&
 * ����1 ) boolean result = ���ǽ� | ���ǽ�2;
 * ex1-1) 
 * 		 �� | ���� => �� : ù��°�� ���̴��� ���� ���� �����Ѵ�.
 * ex1-2)
 * 		 ���� | �� => ��
 * ex1-3)
 * 		 �� | �� => ��
 * ex1-4)
 * 		 ���� | ���� => ����
 * 
 * ����2 ) boolean result = ���ǽ� 1|| ���ǽ�2;
 * ex2-1) 
 * 		 �� || ���� => �� : ù��°�� ���̸� �ڿ� ���� �������� �ʴ´�.
 * ex2-2)
 * 		 ���� || �� => ��
 * ex2-3)
 * 		 �� || �� => �� 
 * ex2-4)
 * 		 ���� || ���� => ����
 *
 * ����3 ) boolean result = ���ǽ�1 & ���ǽ�2;
 * ex3-1) 
 * 		 �� & ���� => ���� 
 * ex3-2)
 * 		 ���� & �� => ����
 * ex3-3)
 * 		 �� & �� => �� 
 * ex3-4)
 * 		 ���� & ���� => ����
 *
 *
 * ����4 ) boolean result = ���ǽ�1 && ���ǽ�2;
 * ex4-1) 
 * 		 �� && ���� => ���� 
 * ex4-2)
 * 		 ���� && �� => ���� : ù��°�� �����̸� ���� ���� �������� �ʴ´�.
 * ex4-3)
 * 		 �� && �� => �� 
 * ex4-4)
 * 		 ���� && ���� => ����
 *
 *
 *
 */
public class OperEx4 {

	public static void main(String[] args) {
		
		boolean result = 3 < 5 | 2 > 5 ;
		System.out.println(result);
		
		result = 3 > 5 || 2 > 5 ;
		System.out.println(result);

		boolean a = true;
		boolean b = false;
		result = a||b;
		System.out.println(result);
		
		int sum = 0;
		a = true;
		result = a || 10 > (sum = 3+5); // �ڿ� ���� ������ �ȵ�
		System.out.println(sum);
		
		result = a | 10 > (sum = 3+5);// �ڿ� ���� ������ ��
		System.out.println(sum);
		System.out.println(result);
		//////////////////////////////////////////////////
		int sum2 = 0;
		boolean a2 = false;
		result = a2 && 10 > (sum2 = 3+4);
		System.out.println(sum2);
		
		result = a2 & 10 > (sum2 = 3+4);
		System.out.println(sum2);
		System.out.println(result);

	}

}
