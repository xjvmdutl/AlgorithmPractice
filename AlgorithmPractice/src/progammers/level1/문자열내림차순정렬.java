package progammers.level1;

import java.util.Arrays;

public class ���ڿ�������������{

	
	public static String solution(String s) {
		/*
			String[] answer = s.split("");//String�� ���� �ٲ��ش�	
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
