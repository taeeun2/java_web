package app;

//���� for��
/*
 * for(���� ���� : ����){
 * 		�ݺ� ���� ����
 * }
 */

public class ForEx3 {

	public static void main(String[] args) {//args �Ű�����
		
		//Run Configurations -> Arguments -> �Է� ex) a b c
		//�� ĭ ���� �� �Է�
		
		
		for(String s : args) {//����("a","b",...)
			System.out.println(s);
		}
	}

}
