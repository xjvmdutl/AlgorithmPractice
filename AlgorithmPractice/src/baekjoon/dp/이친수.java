package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÀÌÄ£¼ö {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static long solution(int n) {
		long[][] dp = new long[n+1][2];
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int i=2;i<=n;++i) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		return dp[n][0] + dp[n][1];
	}

}
