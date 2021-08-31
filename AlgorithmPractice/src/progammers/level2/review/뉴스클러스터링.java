package progammers.level2.review;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링 {
	 public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for(int i=1;i<str1.length();++i) {
        	if(Character.isUpperCase(str1.charAt(i-1)) && Character.isUpperCase(str1.charAt(i))) {
        		String str = String.valueOf(str1.charAt(i-1)) + String.valueOf(str1.charAt(i));
            	list1.add(str);
        	}
        }
        for(int i=1;i<str2.length();++i) {
        	if(Character.isUpperCase(str2.charAt(i-1)) && Character.isUpperCase(str2.charAt(i))) {
        		String str = String.valueOf(str2.charAt(i-1)) + String.valueOf(str2.charAt(i));
        		list2.add(str);
        	}
        	
        }
        if(list1.size() == 0 && list2.size() == 0) {
        	return 65536;
        }
        int inter = 0;
        
        if(list1.size() > list2.size()) {
	        for(int i=0;i<list2.size();++i) {
	        	if(list1.contains(list2.get(i))) {
	        		int idx = list1.indexOf(list2.get(i));
	        		list1.remove(idx);
	        		inter++;
	        	}
	        }
        }else {
        	for(int i=0;i<list1.size();++i) {
	        	if(list2.contains(list1.get(i))) {
	        		int idx = list2.indexOf(list1.get(i));
	        		list2.remove(idx);
	        		inter++;
	        	}
	        }
        }
        int union = list1.size() + list2.size();
       
        double d = (double)inter/union;
        
        return (int) (65536 * d);
    }
	public static void main(String[] args) {
		//str1		str2		answer
		//FRANCE	french		16384
		//handshake	shake hands	65536
		//AAAAB		AAAABB		43690
		//E=M*C^2	e=m*c^2		65536
		System.out.println(solution("FRANCE","french"));
		System.out.println(solution("handshake","shake hands"));
		System.out.println(solution("AAAABBB","AAABBBB"));
		System.out.println(solution("E=M*C^2","e=m*c^2"));
	}

}
