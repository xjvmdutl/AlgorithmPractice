package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱하기혹은더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static long solution(String str) {
		long answer = str.charAt(0)-'0';
		for(int i=1;i<str.length();++i) {
			int num = str.charAt(i) - '0';
			if(num <= 1 || answer <= 1) {
				answer += num;
			}else {
				answer *= num;
			}
		}
		return answer;
	}

}
