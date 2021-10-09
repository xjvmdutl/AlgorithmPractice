package baekjoon.problems.samsungSwTest;

import java.util.Arrays;

public class 문자열재정렬 {

	public static void main(String[] args) {
		String answer = solution("K1KA5CN7");
		System.out.println(answer);
	}

	private static String solution(String str) {
		int sum = 0;
		StringBuilder sb = new StringBuilder();//StringBuilder 쓰는 이유 
		for(int i=0;i<str.length();++i) {
			if(Character.isDigit(str.charAt(i))) {
				sum += str.charAt(i) - '0';
			}else {
				sb.append(str.charAt(i));
			}
		}
		char[] arr = sb.toString().toCharArray();
		Arrays.sort(arr);
		String returns = new String(arr);
		returns += sum;
		return returns;
	}

}
