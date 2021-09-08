package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이곱하기N타일링2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3;i<=n;++i) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		return dp[n];
	}

}
