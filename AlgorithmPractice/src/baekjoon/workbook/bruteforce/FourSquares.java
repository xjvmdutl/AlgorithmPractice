package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {
	private static int solution(int n) {
		
		int[] dp = new int[n + 1];
		dp[1] = 1;
		int min = 0;
		for(int i=2; i<= n; ++i) {
			min = Integer.MAX_VALUE;
			for(int j=1;j * j <= i; ++j) {
				int temp = i - j * j;
				min = Math.min(min, dp[temp]);
			}
			dp[i] = min + 1;
		}
		return dp[n];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}



}
