package app;

public class ArrayEx3 {
// 다차원 배열(array) 행과 열
	/*
	 표현)
	 - int[][] arr = new int[n][n]; -> [행][열]
	 - int[][] arr = {
	 					{n,n},
	 					{n,n},
	 					{n,n}
	 				};=> 3행 2열
	 */
	
	public static void main(String[] args) {
		
		int[][] arr = new int[3][2];
		
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[1][0] = 3;
		arr[1][1] = 4;
		arr[2][0] = 5;
		arr[2][1] = 6;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[2].length;j++) {
				System.out.print("arr["+i+"]["+j+"] = " + arr[i][j]+" ");
			}
			System.out.println();
		}
		
		String[][] str = {{"A","B","C"},{"D","E","F"},{"G","H","I"}};
		//문제 1) 총합과 평균

		int[][] array = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int[] sum = new int[3];
		double[] avg = new double[3];
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				sum[i] += array[i][j];
			}
			avg[i] = (double)sum[i]/array[i].length;
		}
		
		for(int i=0; i<sum.length;i++) {
			System.out.println("총합 : " + sum[i] + " 평균 : "+avg[i]);
		}
		
		//문제 2) 최대값 출력하시오.
		int[] array2 = {1,5,3,8,2};
		int max = array2[0];
		for(int i : array2) {
			if(max<i)
				max=i;
		}
		
		System.out.println("최대값 : " + max);
		
		

	}

}
