package api;

import java.util.ArrayList;

/*
 * Collection
 	- 객체를 담을 수 있는 기억장소
 	- 여러가지 자료를 적절한 형태로 처리하고 저장하는 저장형태(묶음)의 자료구조.
 	- 배열과 비슷하지만, 조금 더 다양한 기능을 사용할 수 있음
 */
public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"DB");
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println("요소 출력 : "+list.get(2));
		
		//캐스팅
		for(int i=0;i<list.size();i++) {
			String str = (String)list.get(i);
			System.out.println(i+" : "+str);
		}
		//object배열같은 구조이다.
	
		System.out.println();
		list.remove(2);
		list.remove("Java");
		
		String skill = (String)list.get(1);
		System.out.println("1 : "+skill);
		
		for(Object o : list)
			System.out.println((String)o);
		
		
		
	}
	

}
