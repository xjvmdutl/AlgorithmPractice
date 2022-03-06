package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class 등수찾기 {
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken()) - 1;
		List<Integer>[][] map = new ArrayList[n][2];
		for(int i=0;i<n;++i) {
			map[i][0] = new ArrayList<>();
			map[i][1] = new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start][0].add(end);
			map[end][1].add(start);
		}
		System.out.println(solution(map, n, m, x));
	}
	private static String solution(List<Integer>[][] map, int n, int m, int x) {
		int count = 0;
		visit = new boolean[n][2];
		int win = bfs(map, n, m, x, 1);
		int lose = bfs(map, n, m, x, 0);
		StringBuilder sb = new StringBuilder();
		sb.append((1 + win) + " " );
		sb.append((n - lose));
		
		
		return sb.toString();
	}
	private static int bfs(List<Integer>[][] map, int n, int m, int x, int flag) {
		Queue<Integer> que = new LinkedList<>();
		int count = 0;
		visit[x][flag] = true;
		que.offer(x);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now][flag]) {
				if(!visit[next][flag]) {
					visit[next][flag] = true;
					count++;
					que.offer(next);
				}
			}
		}
		return count;
	}
}
