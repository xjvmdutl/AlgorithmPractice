package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의독립집합 {
	public static boolean[] visit;
	public static int[][] dp;
	public static StringBuilder sb;
	public static List<Integer> node;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=0;i<n-1;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(solution(map, arr, n));
	}

	private static String solution(List<Integer>[] map, int[] arr, int n) {
		dp = new int[n][2];
		visit = new boolean[n];
		sb = new StringBuilder();
		node = new ArrayList<Integer>();
		dfs(map, arr, 0);
		if(dp[0][0] < dp[0][1]) {
			sb.append(dp[0][1] + "\n");
			trace(map, arr, 0,1);
		}else {
			sb.append(dp[0][0] + "\n");
			trace(map, arr,0,0);
		}
		Collections.sort(node);
		for(int i=0;i<node.size();++i) {
			sb.append((node.get(i)+1) + " ");
		}
		return sb.toString();
	}

	private static void trace(List<Integer>[] map, int[] arr, int now, int attend) {
		visit[now] = true;
		if(attend == 1) {
			node.add(now);
			for(int next : map[now]) {
				if(!visit[next]) {
					trace(map, arr, next, 0);
				}
			}
		}else {
			for(int next: map[now]) {
				if(!visit[next]) {
					if(dp[next][0] < dp[next][1]) {
						trace(map, arr, next, 1);
					}else {
						trace(map, arr, next, 0);
					}
				}
			}
		}
		visit[now] = false;
	}

	private static void dfs(List<Integer>[] map, int[] arr, int now) {
		dp[now][0] = 0; //참석 X
		dp[now][1] = arr[now];
		if(map[now].size() == 0)
			return;
		visit[now] = true;
		for(int next: map[now]) {
			if(!visit[next]) {
				dfs(map, arr, next);
				if(dp[next][0] > dp[next][1]) {
					dp[now][0] += dp[next][0];
				}else {
					dp[now][0] += dp[next][1];
				}
				dp[now][1] += dp[next][0];
			}
		}
		visit[now] = false;
		
	}

}
