package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS¿ÍBFS {
	private static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int v = Integer.parseInt(tokens.nextToken()) - 1;
		List<Integer>[] map = getMap(n);
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(solution(map, n, m, v));
	}

	private static List<Integer>[] getMap(int n) {
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		return map;
	}
	
	private static String solution(List<Integer>[] map, int n, int m, int v) {
		StringBuilder answer = new StringBuilder();
		sortMap(map, n);
		visit = new boolean[n];
		dfs(map, v, answer);
		visit = new boolean[n];
		answer.append("\n");
		bfs(map, v, answer);
		return answer.toString();
	}

	private static void sortMap(List<Integer>[] map, int n) {
		for(int i=0;i<n;++i) {
			Collections.sort(map[i]);
		}
	}
	
	private static void dfs(List<Integer>[] map, int v, StringBuilder answer) {
		answer.append((v + 1) + " ");
		visit[v] = true;
		for(int next : map[v]) {
			if(!visit[next]) {
				dfs(map, next, answer);
			}
		}
	}
	
	private static void bfs(List<Integer>[] map, int v, StringBuilder answer) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(v);
		visit[v] = true;
		answer.append((v+1) + " ");
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(!visit[next]) {
					visit[next] = true;
					answer.append((next+1) + " ");
					que.offer(next);
				}
			}	
		}
		
	}


}
