package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {
	public static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		dp = new long[101];
		solution();
		for(int i=0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			System.out.println(dp[n]);	
		}
		
	}
	private static void solution() {
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for(int i=4;i<=100;++i) {
			dp[i] = dp[i-3] + dp[i-2];
		}
	}
}
