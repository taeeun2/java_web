package api;

import java.util.ArrayList;

/*
 * Collection
 	- ��ü�� ���� �� �ִ� ������
 	- �������� �ڷḦ ������ ���·� ó���ϰ� �����ϴ� ��������(����)�� �ڷᱸ��.
 	- �迭�� ���������, ���� �� �پ��� ����� ����� �� ����
 */
public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"DB");
		int size = list.size();
		System.out.println("�� ��ü �� : " + size);
		System.out.println("��� ��� : "+list.get(2));
		
		//ĳ����
		for(int i=0;i<list.size();i++) {
			String str = (String)list.get(i);
			System.out.println(i+" : "+str);
		}
		//object�迭���� �����̴�.
	
		System.out.println();
		list.remove(2);
		list.remove("Java");
		
		String skill = (String)list.get(1);
		System.out.println("1 : "+skill);
		
		for(Object o : list)
			System.out.println((String)o);
		
		
		
	}
	

}
