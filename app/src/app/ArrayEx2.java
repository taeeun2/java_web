package app;

public class ArrayEx2 {

	public static void main(String[] args) {
		//���� 1)
		//�� �հ� ��� ���ϱ�
		int[] scores = {83, 90, 87};
		int sum = 0;
		for(int i : scores) {
			sum+=i;
		}
		System.out.println("���� : "+sum);
		double avg = (double)sum/scores.length;
		System.out.println("��� : "+avg);
		
		//���� 2)
		//¦���� ����Ͻÿ�.
		int su[] = {3,6,4,7,10};
		for(int i=0;i<su.length;i+=2) {
			System.out.println(su[i]);
		}
		
		//���� 3)
		//������ �� 3, 7���� ���� ����迭�� �����Ͻÿ�.
		
		int[] dan = {3,7};
		int[] result = new int[2];
		
		for(int i=0;i<result.length;i++) {
			for(int j=1;j<10;j++) {
				result[i]+=dan[i]*j;
			}
		}
		
		for(int a : result) 
			System.out.println(a);
		
		
		
		
		
	}
}
