package app;

public class ArrayEx2 {

	public static void main(String[] args) {
		//문제 1)
		//총 합과 평균 구하기
		int[] scores = {83, 90, 87};
		int sum = 0;
		for(int i : scores) {
			sum+=i;
		}
		System.out.println("총합 : "+sum);
		double avg = (double)sum/scores.length;
		System.out.println("평균 : "+avg);
		
		//문제 2)
		//짝수만 출력하시오.
		int su[] = {3,6,4,7,10};
		for(int i=0;i<su.length;i+=2) {
			System.out.println(su[i]);
		}
		
		//문제 3)
		//구구단 중 3, 7단의 합을 결과배열에 저장하시오.
		
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
