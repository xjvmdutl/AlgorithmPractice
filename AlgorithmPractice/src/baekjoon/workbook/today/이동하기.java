package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map =  new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(int[][] map, int n, int m) {
		int[][] dp = new int[n][m];
		dp[0][0] = map[0][0];
		for(int i=1;i<n;++i) {
			dp[i][0] = dp[i-1][0] + map[i][0];
		}
		for(int i=1;i<m;++i) {
			dp[0][i] = dp[0][i-1] + map[0][i];
		}
		for(int i=1;i<n;++i) {
			for(int j=1;j<m;++j) {
				dp[i][j] = Math.max(Math.max(dp[i-1][j] + map[i][j], dp[i][j-1] + map[i][j]), dp[i-1][j-1] + map[i][j]);
			}	
		}
		return dp[n-1][m-1];
	}
}
