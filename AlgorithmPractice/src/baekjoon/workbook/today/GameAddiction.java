package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class GameAddiction {
	public static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int H = Integer.parseInt(tokens.nextToken());
		int N = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(H, N));
	}

	private static long solution(int h, int n) {
		dp = new long[31][31];
		if(h > n) {
			int tmp = h;
			h = n;
			n = tmp;
		}
		for(int i=h;i<=n;++i) {
			dp[h][i] = 1;
		}
		for(int i=h+1;i<=n;++i) {
			for(int j=h+1;j<=n;++j) {
				if(i <= j) {
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
				}
			}
		}
		return dp[n][n];
	}
}
