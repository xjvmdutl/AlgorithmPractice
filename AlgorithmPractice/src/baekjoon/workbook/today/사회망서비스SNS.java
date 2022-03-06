package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사회망서비스SNS {
	public static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(solution(map, n));
	}

	private static int solution(List<Integer>[] map, int n) {
		dp = new int[n][2];
		dfs(map, 0, -1);
		
		return Math.min(dp[0][0], dp[0][1]);
	}

	private static void dfs(List<Integer>[] map, int now, int parent) {
		dp[now][0] = 0;
		dp[now][1] = 1;
		
		for(int next : map[now]) {
			if(next != parent) {
				dfs(map, next, now);
				dp[now][0] += dp[next][1];
				dp[now][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
		
	}

}
