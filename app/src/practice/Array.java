package practice;

import java.util.Scanner;
	
	public class Array {
	
		static int seqSearch(int[] a, int n, int key) {
			int i=0;
			while(true){
				if(i==n)
					return -1;
				if(a[i] == key)
					return i;
				
				i++;
			}
		}
		public static void main(String[] args) {
			//1000이하의 소수를 나열하는 프로그램
			int ptr = 0;//찾는 소수의 개수
			int[] prime = new int[500];//소수를 저장하는 배열
			prime[ptr++] = 2;//2는 소수
			
			
			for(int i=3;i<=1000;i+=2) {//대상은 홀수만
				int k;
				for(k =1;k<ptr;k++) {//이미 찾은 소수로 나눔
					if(i%prime[k]==0)//나누어 떨어지면 소수가 아님
						break;
				}
				if(k==ptr)//마지막까지 나누어 떨어지지 않음
					prime[ptr++]=i;//소수라고 배열에 저장
			}
			
			for(int p=0;p<ptr;p++) 
				System.out.println(prime[p]);
		}
	}
