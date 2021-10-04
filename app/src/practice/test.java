package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {




	public static String solution(int[][] scores) {
        
		int length = scores.length;
		int[] sums = new int[length];
	
		ArrayList<Integer> list = new ArrayList<>();
	
		
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				list.add(scores[i][j]);
			}
		}
		
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(Collections.max(list)==scores[i][j]&&i==j)
					list.remove(i+j);
				else if(Collections.min(list)==scores[i][j]&&i==j)
					list.remove(i+j*length);
			}
		}
		
		for(int lists : list) {
			System.out.println(lists);
		}
		
        String answer = "";
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[2][2];
		for(int i=0;i<arr.length;i++ ) {
			for(int j=0;j<arr.length;j++){
				System.out.print("i : "+i+"/ j : "+j+">");
				arr[i][j] = scan.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

}
