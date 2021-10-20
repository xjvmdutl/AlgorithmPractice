package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수3 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}

	private static long solution(int n, int k) {
		long[][] dp = new long[n+1][40000001];
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i=2;i<=n;++i) {
			dp[i][0] = 1;
			for(int j=1;j<=i;++j) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%1000000007;
			}
		}
		return dp[n][k];
	}

}
