package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static long solution(int n) {
		long[] dp = new long[n+1];
		if(n <= 0)
			return 0;
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=n;++i) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		return dp[n];
	}

}
