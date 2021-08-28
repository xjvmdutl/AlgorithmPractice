package progammers.level1.review;

import java.util.StringTokenizer;

public class 이상한문자만들기 {
	public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0;i<s.length();++i) {
        	if(s.charAt(i) == ' ') {
        		idx = 0;
        		sb.append(s.charAt(i));
        		continue;
        	}
        	if(idx % 2 == 0) {
        		sb.append(Character.toUpperCase(s.charAt(i)));
        	}else {
        		sb.append(Character.toLowerCase(s.charAt(i)));
        	}
        	idx++;
        }
    	return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(solution("WoRlD  sd"));
	}

}
