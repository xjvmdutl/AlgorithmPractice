package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class มกวม {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n));
	}

	private static long solution(int[][] map, int n) {
		long[][] dp = new long[n][n];
		dp[0][0] = 1;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(i == n-1 && j == n-1)
					continue;
				if(isRange(i + map[i][j], j, n)) {
					dp[i+map[i][j]][j] += dp[i][j];
				}
				if(isRange(i, j  + map[i][j] , n)) {
					dp[i][j+map[i][j]] += dp[i][j];
				}
			}	
		}
		return dp[n-1][n-1];
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
