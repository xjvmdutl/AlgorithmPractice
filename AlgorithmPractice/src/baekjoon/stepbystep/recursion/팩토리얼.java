package baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class ÆÑÅä¸®¾ó {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 1;
		for(int i=1;i<=n;++i) {
			answer *= i;
		}
		return answer;
	}
	
}
