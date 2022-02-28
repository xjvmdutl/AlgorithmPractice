package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기 {
	private static final int INF = 300001;
	public static int[] dis;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken()) - 1;
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
		}
		System.out.println(solution(map, n, m, k, x));
	}

	private static String solution(List<Integer>[] map, int n, int m, int k, int x) {
		dis = new int[n];
		Arrays.fill(dis, INF);
		StringBuilder sb = new StringBuilder();
		dilk(map, k, x);
		for(int i=0;i<n;++i) {
			if(dis[i] == k) {
				sb.append(i+1 + "\n");
			}
		}
		return sb.length() == 0 ? "-1" : sb.toString();
	}

	private static void dilk(List<Integer>[] map, int k, int x) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		dis[x] = 0;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(dis[next] > dis[now] + 1) {
					dis[next] = dis[now] + 1;
					que.offer(next);
				}
			}
		}
	}

}
