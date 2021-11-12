package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS¿ÍBFS {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int v = Integer.parseInt(tokens.nextToken()) - 1;
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i)
			map[i] = new ArrayList<>();
		for(int i=0;i<m;++i){
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(dfs(map,n,v));
		System.out.println(bfs(map,n,v));
	}

	private static String bfs(List<Integer>[] map, int n, int v) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		visit = new boolean[n];
		visit[v] = true;
		que.offer(v);
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append((now+1) + " ");
			Collections.sort(map[now]);
			for(int next : map[now]) {
				if(!visit[next]) {
					visit[next] = true;
					que.offer(next);
				}
			}
		}
		return sb.toString();
	}

	private static String dfs(List<Integer>[] map, int n, int v) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		visit = new boolean[n];
		stack.push(v);
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(!visit[now]) {
				visit[now] = true;
				sb.append((now+1) + " ");
				Collections.sort(map[now],(o1,o2)->o2-o1);
				for(int next : map[now]) {
					if(!visit[next]) {
						stack.push(next);
					}
				}
			}
		}
		return sb.toString();
	}

}
