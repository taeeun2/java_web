package app;

public class ArgsEx {

	public static void main(String[] args) {
	
		String str = args[0];
		int su = Integer.parseInt(str);//���ڿ��� ������ ��ȯ�ϴ� �Լ�
		//���ڿ��� ���ڿ��� ����
		boolean result = su%2==0;
		
		if(result)
			System.out.println("¦�� �Դϴ�.");
		else
			System.out.println("Ȧ�� �Դϴ�.");
		
		
		
	}

}
