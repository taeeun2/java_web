package api;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx {

	public static void main(String[] args) {
		//Hashtable ����ȭ ó��(o), map ����ȭ ó��(x)
		//�ٸ� ��ɵ��� �����ϴ�.
		Map<String, String> map = new HashMap<>();
		map.put("spring", "1");
		map.put("summer", "2");
		map.put("fall", "3");
		map.put("winter", "4");
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("���̵�� ��й�ȣ�� �Է����ּ���");
			System.out.println("���̵� : ");
			String id = scan.next();
			System.out.println("��й�ȣ : ");
			String pw = scan.next();
			System.out.println();
			if(map.containsKey(id)) {
				if(map.get(id).equals(pw)) {
					System.out.println("�α��� ����");
					scan.close();
					break;
				}
				else
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
			else
				System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.");
			
				
		}


	}

}
