package progammers.level2;


import java.util.ArrayList;
import java.util.Collections;

import java.util.List;


public class 뉴스클러스터링 {
	public static int solution(String str1, String str2) {
      
		  	str1 = str1.toUpperCase(); // 모두 대문자로 
			str2 = str2.toUpperCase();
	        List<String> str1Data = new ArrayList<>();
	        List<String> str2Data = new ArrayList<>();
	        for(int i=0;i<str1.length()-1;++i){
	            char c1 = str1.charAt(i);
	            char c2 = str1.charAt(i+1);
	            if(Character.isLetter(c1)
	              && Character.isLetter(c2)){
	                String str = Character.toString(c1) + Character.toString(c2);
	                str1Data.add(str);
	            }
	        }
	        for(int i=0;i<str2.length()-1;++i){
	            char c1 = str2.charAt(i);
	            char c2 = str2.charAt(i+1);
	            if(Character.isLetter(c1)
	              && Character.isLetter(c2)){
	                String str = Character.toString(c1) + Character.toString(c2);
	                str2Data.add(str);
	            }
	        }
	        Collections.sort(str1Data);
	        Collections.sort(str2Data);
	        List<String> union = new ArrayList<>();
	        List<String> intersection = new ArrayList<>();
	        for(String s : str1Data){
	            if(str2Data.remove(s))
	            	union.add(s);
	            intersection.add(s);
	        }
	        for(String s : str2Data){
	        	union.add(s);
	        }
	        double jakard = 1;
	        if(union.size() == 0)
				jakard = 1;	// 공집합일 경우 1
			else
				jakard = (double) intersection.size() / (double) union.size();
	         
	        
	        
	        
	        
	        
	        return (int)(jakard*65536);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//str1	str2	answer
		//FRANCE	french	16384
		//handshake	shake hands	65536
		//aa1+aa2	AAAA12	43690
		//E=M*C^2	e=m*c^2	65536
		String str1_1 = "FRANCE";
		String str2_1 = "french";
		System.out.println(solution(str1_1, str2_1));
		String str1_2 = "handshake";
		String str2_2 = "shake hands";
		System.out.println(solution(str1_2, str2_2));
		String str1_3 = "aa1+aa2";
		String str2_3 = "AAAA12";
		System.out.println(solution(str1_3, str2_3));
		String str1_4 = "E=M*C^2";
		String str2_4 = "e=m*c^2";
		System.out.println(solution(str1_4, str2_4));
		
	}

}
