package bak_jun;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public static String solution(String new_id) {
        
        String answer = new_id;
        char[] alright = {'-','_','.'};
        List<Character> list = new ArrayList<>();
       
        //1단게
        answer.toLowerCase();
		//2단계
        char[] char_arr = answer.toCharArray();
        
        for(int i=0;i<char_arr.length;i++) {
        	if(Character.isDigit(char_arr[i])||Character.isAlphabetic(char_arr[i]))
        		list.add(char_arr[i]);
        	for(int j=0;j<alright.length;j++)
        		if(char_arr[i]==alright[j])
        			list.add(char_arr[i]);
        }
        
        
        
       answer = list.toString();
		
		
        return answer;
    }
	    
	    public static void main(String[] args) {
	    	
	    	System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		}

}
