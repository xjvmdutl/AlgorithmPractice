package baekjoon.workbook.shortestpath;

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

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken()) - 1;
		List<Integer>[] map = getMap(n);
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
		}
		System.out.println(solution(map, n, k, x));
	}

	private static List<Integer>[] getMap(int n) {
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		return map;
	}
	
	private static String solution(List<Integer>[] map, int n, int k, int x) {
		int[] distances = dilkstra(map, n, x);
		return getResult(distances, k);
	}

	private static int[] dilkstra(List<Integer>[] map, int n, int x) {
		int[] distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		distances[x] = 0;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(distances[next] > distances[now] + 1) {
					distances[next] = distances[now] + 1;
					que.offer(next);
				}
			}
		}
		return distances;
	}
	
	private static String getResult(int[] distances, int k) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<distances.length;++i) {
			if(isK(distances[i], k)) {
				answer.append((i +1 ) + "\n");
			}
		}
		return answer.isEmpty() ? "-1" : answer.toString();
	}

	private static boolean isK(int num, int k) {
		return num == k;
	}
}
