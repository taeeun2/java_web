package app;

//switch ~ case��

/*
 *  ǥ��)
 *  	switch (��){
 *  	case �� 1:
 *  		���� ���� 1;
 *  	case �� 2:
 *  		���� ���� 2;
 *  		break;(����)
 *  	case �� 3:
 *  		���� ���� 3;
 *  		.
 *  		.
 *  		.
 *  	default: (else���� ����)
 *  		���� ���� 4;
 *  		break;(����)
 */

public class SwitchEx {

	public static void main(String[] args) {
		int val = 2;
		switch(val) {
			case 1:
				System.out.println("���౸�� 1");
			case 2:
				System.out.println("���౸�� 2");
				break;
			case 3:
				System.out.println("���౸�� 3");
				break;
			case 4:
				System.out.println("���౸�� 4");
			default:
				System.out.println("�⺻");
		}

	}

}
