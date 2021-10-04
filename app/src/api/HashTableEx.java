package api;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableEx {

	public static void main(String[] args) {
		
		//<key, value>
		//key������ value�� ã�Ƴ���.
		Map<String, String> map = new Hashtable<>(); 
		map.put("a1", "��1");
		map.put("a2", "��2");
		map.put("a3", "��3");
		//���� Ű���� �˾ƾ��Ѵ�.
		String result = map.get("a2");
		System.out.println(result);
		
		
		Set<String> keyset = map.keySet();
		Iterator<String> it = keyset.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.print("Ű : "+key + " ");
			System.out.println("�� : " +map.get(key));
		}
		map.remove("a1");
		System.out.println("�� Entry �� : " + map.size());
	
	}

}
