package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class ¼û¹Ù²ÀÁú3 {
	private static final int INF = 100001;
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		dp = new int[INF];
		Arrays.fill(dp, INF);
		Queue<Integer> que = new LinkedList<>();
		dp[n] = 0;
		que.offer(n);
		while(!que.isEmpty()) {
			int now = que.poll();
			int next = now + 1;
			int before = now - 1;
			int tel = now * 2;
			if(next < INF && dp[next] > dp[now] + 1) {
				dp[next] = dp[now]+1;
				que.offer(next);
			}
			if(0 <= before && dp[before] > dp[now] + 1) {
				dp[before] = dp[now]+1;
				que.offer(before);
			}
			if(tel < INF && dp[now] < dp[tel] ) {
				dp[tel] = dp[now];
				que.offer(tel);
			}
		}
		return dp[k];
	}
}
