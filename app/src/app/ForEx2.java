package app;

/*
 * ǥ��)
 * for(���� ����(�ʱ�ȭ);���ǽ�;���� Ȥ�� ���� ����){
 * 		���� ���� 1;
 * 		for(���� ����(�ʱ�ȭ); ���ǽ�; ���� Ȥ�� ���� ����){
 * 			���� ���� 2;
 * 			}
 *  }
 */

public class ForEx2 {

	public static void main(String[] args) {
		
		//������ 9�ܱ��� ����Ͻÿ�.
		for(int i = 1; i < 10; i++ ) {
			System.out.println(i+"��");
			for(int j = 1 ; j < 10 ; j++) {
				System.out.println(i+"*"+j+"="+(i*j));
			}
			System.out.println();
		}

		
		//������ ��� �ٸ� ���
		for(int i = 1;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.print(j+"*"+i+"="+(j*i)+"\t");
			}
			System.out.println();
		}
		
		//�� ����ϱ�
		for(int i = 1; i<6;i++) {
			for(int j = 1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		//�� �ݴ�� ����ϱ�
		
		for(int i = 1; i<6;i++) {
			for(int j = 1;j<=6-i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}

}
