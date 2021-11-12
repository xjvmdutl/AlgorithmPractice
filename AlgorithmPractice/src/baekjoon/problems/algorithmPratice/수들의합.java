package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(reader.readLine());
		System.out.println(solution(s));
	}

	private static long solution(long s) {
		long sum = 0;
		int idx = 0;
		while(sum <= s) {
			sum += ++idx;
		}
		
		return idx-1;
	}

}
