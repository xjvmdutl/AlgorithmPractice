package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹 {
	private static boolean[] visit;
	private static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		List<Integer>[] map = getMap(n);
		
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken()) - 1;
			int b = Integer.parseInt(tokens.nextToken()) - 1;
			map[a].add(b);
		}
		System.out.println(solution(map, n));
	}


	private static List<Integer>[] getMap(int n) {
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<Integer>();
		}
		return map;
	}


	private static String solution(List<Integer>[] map, int n) {
		dp = new int[n];
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<n;++i) {
			bfs(map, n, i);
		}
		int max = Arrays.stream(dp).max().getAsInt();
		return print(max);
	}


	private static void bfs(List<Integer>[] map, int n, int start) {
		Queue<Integer> que = new LinkedList<>();
		visit = new boolean[n];
		visit[start] = true;
		que.offer(start);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(!visit[next]) {
					dp[next]++;
					visit[next] = true;
					que.offer(next);
				}
			}
		}
	}

	private static String print(int max) {
		StringBuilder answer = new StringBuilder();
		for(int i=1;i<=dp.length;++i) {
			if(dp[i-1] == max) {
				answer.append(i + " ");
			}
		}
		return answer.toString();
	}

}
