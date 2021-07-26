package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A¿ÍB {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String t = reader.readLine();
		System.out.println(solution(s,t));
	}

	private static int solution(String s, String t) {
		int answer = 0;
		StringBuilder start = new StringBuilder(s);
		StringBuilder result = new StringBuilder(t);
		while(start.length() < result.length()) {
			if(result.charAt(result.length()-1) == 'A') {
				result.deleteCharAt(result.length()-1);
			}else if(result.charAt(result.length()-1) == 'B') {
				result.deleteCharAt(result.length()-1);
				result.reverse();
			}
		}
		if(result.toString().equals(start.toString()))
			answer=1;
		return answer;
	}
}
