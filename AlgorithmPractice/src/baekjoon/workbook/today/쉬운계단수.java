package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수 {
	private static final int INF = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
		
	}

	private static int solution(int n) {
		int answer = 0;
		int[][] dp = new int[n+1][10];
		for(int i=1;i<=9;++i) {
			dp[1][i] = 1;
		}
		for(int i=2;i<=n;++i) {
			for(int j=0;j<=9;++j) {
				if(j==0) dp[i][j] = dp[i-1][1] % INF;
				else if(j == 9) dp[i][j] = dp[i-1][8] % INF;
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%INF;
			}
		}
		for(int i=0;i<=9;++i) {
			answer += dp[n][i];
			answer%=INF;
		}
		return answer;
	}

}
