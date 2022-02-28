package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 팰린드로미터 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = reader.readLine()) != null) {
			if(str.equals("0"))
				break;
			System.out.println(solution(str));
		}
	}

	private static int solution(String str) {
		int answer = 0;
		int length = str.length();
		while(!isFalindrop(str, length)) {
			int now = Integer.parseInt(str) + 1;
			StringBuilder sb = new StringBuilder(String.valueOf(now));
			while(sb.length() < length) {
				sb.insert(0, "0");
			}
			str = sb.toString();
			answer++;
		}
		return answer;
	}

	private static boolean isFalindrop(String str, int length) {
		for(int i=0;i<length/2;++i) {
			if(str.charAt(i) != str.charAt(length-i-1))
				return false;
		}
		return true;
	}
}
