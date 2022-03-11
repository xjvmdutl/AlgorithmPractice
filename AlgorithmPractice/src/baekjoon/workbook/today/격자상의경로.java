package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 격자상의경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n, m, k));
	}

	private static int solution(int n, int m, int k) {
		int[][] dp = new int[n][m];
		dp[0][0] = 1;
		if(k == 0) {
			counting(dp, 0, 0, n, m);
		}else {
			int dx = (k-1) % m;
			int dy = (k-1) / m;
			counting(dp, 0, 0, dy+1, dx+1);
			counting(dp, dy, dx, n, m);
		}
		
		return dp[n-1][m-1];
	}

	private static void counting(int[][] dp, int y, int x, int n, int m) {
		for(int i=y+1;i<n;++i) {
			dp[i][x] = dp[y][x];
		}
		for(int i=x+1;i<m;++i) {
			dp[y][i] = dp[y][x];
		}
		for(int i=y+1;i<n;++i) {
			for(int j=x+1;j<m;++j) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}	
		}
	}

}
