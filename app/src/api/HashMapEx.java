package api;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx {

	public static void main(String[] args) {
		//Hashtable 동기화 처리(o), map 동기화 처리(x)
		//다른 기능들은 동일하다.
		Map<String, String> map = new HashMap<>();
		map.put("spring", "1");
		map.put("summer", "2");
		map.put("fall", "3");
		map.put("winter", "4");
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요");
			System.out.println("아이디 : ");
			String id = scan.next();
			System.out.println("비밀번호 : ");
			String pw = scan.next();
			System.out.println();
			if(map.containsKey(id)) {
				if(map.get(id).equals(pw)) {
					System.out.println("로그인 성공");
					scan.close();
					break;
				}
				else
					System.out.println("비밀번호가 일치하지 않습니다.");
			}
			else
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			
				
		}


	}

}
