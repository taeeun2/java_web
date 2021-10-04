package api;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableEx {

	public static void main(String[] args) {
		
		//<key, value>
		//key값으로 value를 찾아낸다.
		Map<String, String> map = new Hashtable<>(); 
		map.put("a1", "값1");
		map.put("a2", "값2");
		map.put("a3", "값3");
		//먼저 키값을 알아야한다.
		String result = map.get("a2");
		System.out.println(result);
		
		
		Set<String> keyset = map.keySet();
		Iterator<String> it = keyset.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.print("키 : "+key + " ");
			System.out.println("값 : " +map.get(key));
		}
		map.remove("a1");
		System.out.println("총 Entry 수 : " + map.size());
	
	}

}
