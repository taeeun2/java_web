package api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java");
		int size = set.size();
		System.out.println("ÃÑ °´Ã¼¼ö:"+size);
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t"+element);
		}
		
		
		set.remove("JSP");
		set.remove("Java");
		int size2 = set.size();
		System.out.println("ÃÑ °´Ã¼¼ö:"+size2);
	
		
		for(String element : set) {
			System.out.println("\t"+element);
		}
		
		set.clear();
		if(set.isEmpty()) {
			System.out.println("ºñ¾îÀÖÀ½");
		}

	}

}
