package api;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class VectorEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//����ȭó���� �Ǿ��ִ�.
		//�ӵ��� ArrayList�� �� ������.
		Vector vc = new Vector();
		
		//��ü ����
		vc.add("ȫ�浿");
		vc.add("���ڹ�");
		vc.add("���ڹ�");
		//��ü ����
		String str1 = (String)vc.get(0);
		String str2 = (String)vc.get(1);
		String str3 = (String)vc.get(2);
		//���
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println("�̸��� �Է��ϼ��� : ");
		String name = new Scanner(System.in).next();
		int index = vc.indexOf(name);
		if(vc.contains(name)) {
			System.out.println("�˻���� ���� :"+vc.get(index));
			if(vc.remove(name)) {
				System.out.println("���� �Ϸ�!");
			}
			System.out.println("<��� ��� ǥ��1>");
			for(int i=0;i<vc.size();i++) {
				String str = (String)vc.get(i);
				System.out.println(str);
			}
			System.out.println("<��� ��� ǥ��2>");
			Iterator it = vc.iterator();
			while(it.hasNext()) {
				String str = (String)it.next();
				System.out.println(str);
			}
			
			System.out.println("<��� ��� ǥ��3>");
			Enumeration e = vc.elements();
			while(e.hasMoreElements()) {
				String str = (String)e.nextElement();
				System.out.println(str);
			}
			
			System.out.println("<��� ��� ǥ��4>");
			for(Object obj : vc) {
				String str = (String)obj;//or obj.toString
				System.out.println(str);
			}

		}
		
		else
			System.out.println("�˻� ��� ����");

		
	}

}
