package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}
	private static long solution(int n) {
		int[][] dp = new int[n+1][10];
		for(int i=0;i<10;++i) {
			dp[1][i] = 1;
		}
		for(int i=2;i<=n;++i) {
			for(int j=0;j<10;++j) {
				if(j==0) dp[i][j] = dp[i-1][1]%1000000000;
                else if(j==9) dp[i][j] = dp[i-1][8]%1000000000;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
			}
		}
		long answer = 0;
		for(int i=1;i<10;++i) {
			answer += dp[n][i];
		}
		return answer%1000000000;
	}
}
