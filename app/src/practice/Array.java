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
			//1000������ �Ҽ��� �����ϴ� ���α׷�
			int ptr = 0;//ã�� �Ҽ��� ����
			int[] prime = new int[500];//�Ҽ��� �����ϴ� �迭
			prime[ptr++] = 2;//2�� �Ҽ�
			
			
			for(int i=3;i<=1000;i+=2) {//����� Ȧ����
				int k;
				for(k =1;k<ptr;k++) {//�̹� ã�� �Ҽ��� ����
					if(i%prime[k]==0)//������ �������� �Ҽ��� �ƴ�
						break;
				}
				if(k==ptr)//���������� ������ �������� ����
					prime[ptr++]=i;//�Ҽ���� �迭�� ����
			}
			
			for(int p=0;p<ptr;p++) 
				System.out.println(prime[p]);
		}
	}
