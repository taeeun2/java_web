package api;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx2 {

	public static void main(String[] args) {
		Set<Member2> set = new HashSet<>();
		set.add(new Member2("ȫ�浿",10));
		set.add(new Member2("ȫ�浿",10));

		System.out.println("�� ��ü�� : "+set.size());
		System.out.println(new Member2("ȫ�浿",10).equals(new Member2("ȫ�浿",10)));
		System.out.println(new Member2("ȫ�浿",10).hashCode());
		System.out.println(new Member2("ȫ�浿",10).hashCode());

		
	}

}
