package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class 우유도시 {
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

	private static int solution(int[][] map, int n) {
		int[][][] dp = new int[n][n][3];
		if(map[0][0] == 0)
			dp[0][0][0] = 1;
		for(int i=1;i<n;++i) {
			int milk = map[0][i];
			dp[0][i][0] = milk == 0 ? dp[0][i-1][2] + 1 : dp[0][i-1][0];//딸기
			dp[0][i][1] = milk == 1 
					&& dp[0][i][2] < dp[0][i][0] ? dp[0][i-1][0] + 1 : dp[0][i-1][1];//초코
			dp[0][i][2] = milk == 2 
					&& dp[0][i][0] < dp[0][i][1] ? dp[0][i-1][1] + 1 : dp[0][i-1][2];//바나나
		}
		
		for(int i=1;i<n;++i) {
			int milk = map[i][0];
			dp[i][0][0] = milk == 0 ? dp[i-1][0][2] + 1 : dp[i-1][0][0];//딸기
			dp[i][0][1] = milk == 1 
					&& dp[i][0][2] < dp[i][0][0] ? dp[i-1][0][0] + 1 : dp[i-1][0][1];//초코
			dp[i][0][2] = milk == 2 
					&& dp[i][0][0] < dp[i][0][1] ? dp[i-1][0][1] + 1 : dp[i-1][0][2];//바나나
		}
		for(int i=1;i<n;++i) {
			for(int j=1;j<n;++j) {
				int milk = map[i][j];
				dp[i][j][0] = milk == 0 ?
						Math.max(dp[i][j-1][2] + 1, dp[i - 1][j][2] + 1) 
						: Math.max(dp[i][j-1][0], dp[i - 1][j][0]);//딸기
				dp[i][j][1] = milk == 1 && dp[i][j][2] < dp[i][j][0]?
						Math.max(dp[i][j-1][0] + 1, dp[i-1][j][0] + 1) 
						: Math.max(dp[i][j-1][1], dp[i - 1][j][1]);//초코
				dp[i][j][2] = milk == 2 && dp[i][j][0] < dp[i][j][1]? 
						Math.max(dp[i][j-1][1] + 1, dp[i-1][j][1] + 1) 
						: Math.max(dp[i][j-1][2], dp[i-1][j][2]);//바나나
			}	
		}
		
		return Math.max(Math.max(dp[n-1][n-1][0], dp[n-1][n-1][1]), dp[n-1][n-1][2]);
	}
}
