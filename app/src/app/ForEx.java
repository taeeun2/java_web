package app;

//�ݺ���(for��)
/*
 * ǥ��)
 * for(���� ����(�ʱ�ȭ); ���ǽ�; ���� Ȥ�� ���� ����){
 * 		���� ����;
 * }
 * 
 */
public class ForEx {

	public static void main(String[] args) {
		
		int i=0;
		for(;i<10;i++) {
			System.out.println(i);
		}
		// ���� 1) 1~100������ ���� ���Ͻÿ�.
		
		int sum = 0;
		for(int j = 1;j<=100;j++) {
			sum+=j;
		}
		
		System.out.println(sum);
		
		//���� 2) 1~100���� ¦���� �� ���
		int sum2 = 0;
		for(int j = 2;j<=100;j+=2) {
			sum2+=j;
		}
		
		System.out.println(sum2);
		
		sum = 0;
		for(int k = 1; k<=100;k++) {
			if(k%2==0)
				sum+=k;
		}
		System.out.println(sum);
		
		//���� 3) 1~100���� Ȧ���� �� ���
		int sum3 = 0;
		for(int j = 1;j<=100;j+=2) {
			sum3+=j;
		}
				
		System.out.println(sum3);
				

	}

}
