package app;

/*
 * 증가, 감소 연산자
 * 형식)
 * 		--
 * 		++
 * 
 * 		ex)
 * 		int a = 0;
 * 		++a; // => 결과 : 1
 * 		--a; // => 결과 : 0
 * 		
 * 		a++;
 * 		a--;
 * 
 */
public class OperEx6 {

	public static void main(String[] args) {
		
		int su = 0;
		System.out.println(su++);//선행 =>0
		System.out.println(su);//디음 줄에 실행이 된다=>1
		System.out.println(++su);//후행 -> 바로 실행이 된다=>2
		System.out.println(--su);//1
		
		System.out.println("/");
		
		int a = 0;
		System.out.println(a++ + a++);//0 + 1 = 1
		System.out.println(a + --a + ++a);//2 + 1 + 2 = 5
		System.out.println(--a + a++);//1 + 1 = 2
		System.out.println(a);//2
		
		
	}

}
