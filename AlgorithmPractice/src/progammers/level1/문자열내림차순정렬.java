package progammers.level1;

import java.util.Arrays;

public class 문자열내림차순정렬{

	
	public static String solution(String s) {
		/*
			String[] answer = s.split("");//String로 전부 바꿔준다	
			Arrays.sort(answer,Collections.reverseOrder());
			return String.join("", answer);
		*/		
		char[] answer = s.toCharArray();
        Arrays.sort(answer);
        
        return new StringBuffer(s).reverse().toString();
	}
	public static void main(String[] args) {
		String s = solution("Zbcdefg");
	}

}
