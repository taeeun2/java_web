package app;

/*
 * ����, ���� ������
 * ����)
 * 		--
 * 		++
 * 
 * 		ex)
 * 		int a = 0;
 * 		++a; // => ��� : 1
 * 		--a; // => ��� : 0
 * 		
 * 		a++;
 * 		a--;
 * 
 */
public class OperEx6 {

	public static void main(String[] args) {
		
		int su = 0;
		System.out.println(su++);//���� =>0
		System.out.println(su);//���� �ٿ� ������ �ȴ�=>1
		System.out.println(++su);//���� -> �ٷ� ������ �ȴ�=>2
		System.out.println(--su);//1
		
		System.out.println("/");
		
		int a = 0;
		System.out.println(a++ + a++);//0 + 1 = 1
		System.out.println(a + --a + ++a);//2 + 1 + 2 = 5
		System.out.println(--a + a++);//1 + 1 = 2
		System.out.println(a);//2
		
		
	}

}
