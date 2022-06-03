package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A¿ÍB2 {
	private static int solution(String s, String t) {
		return permutation(s, t);
	}
	
	private static int permutation(String s, String t) {
		if(s.length() == t.length()) {
			if(s.equals(t)) {
				return 1;
			}
			return 0;
		}
		int answer = 0;
		if(t.charAt(0) == 'B') {
			StringBuilder remove = new StringBuilder(t.substring(1));
			answer += permutation(s, remove.reverse().toString());
		}
		if(t.charAt(t.length()-1) == 'A') {
			answer += permutation(s, t.substring(0, t.length()-1));
		}
		return answer > 0 ? 1 : 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String t = reader.readLine();
		System.out.println(solution(s, t));
	}
}
