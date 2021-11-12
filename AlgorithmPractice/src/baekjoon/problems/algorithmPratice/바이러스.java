package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Integer>[] map = new ArrayList[n];
		int m = Integer.parseInt(reader.readLine());
		for(int i=0;i<n;++i)
			map[i] = new ArrayList<>();
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			map[start].add(end);
			map[end].add(start);
		}
		System.out.println(solution(map,n));
	}

	private static int solution(List<Integer>[] map, int n) {
		visit = new boolean[n];
		int answer = bfs(map);
		return answer;
	}

	private static int bfs(List<Integer>[] map) {
		int size = 0;
		Queue<Integer> que = new LinkedList<>();
		que.offer(0);
		visit[0] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(!visit[next]) {
					visit[next] = true;
					que.offer(next);
					size++;
				}
			}
		}
		return size;
	}
}
