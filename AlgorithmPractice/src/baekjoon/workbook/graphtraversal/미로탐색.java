package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¹Ì·ÎÅ½»ö {
	private static final int START_X = 0;
	private static final int START_Y = 0;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static boolean[][] visit;
	static  class Miro implements Comparable<Miro>{
		int x;
		int y;
		int distance;
		public Miro(int x,int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		@Override
		public int compareTo(Miro o) {
			return this.distance - o.distance;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(char[][] map, int n, int m) {
		visit = new boolean[n][m];
		int answer = bfs(map, n, m);
		return answer;
	}

	private static int bfs(char[][] map, int n, int m) {
		Queue<Miro> que = new PriorityQueue<>();
		que.offer(new Miro(START_X, START_Y, 1));
		visit[START_Y][START_X] = true;
		while(!que.isEmpty()) {
			Miro miro = que.poll();
			if(isGoal(miro.x, miro.y, n, m)) {
				return miro.distance;
			}
			for(int i=0;i<4;++i) {
				int nx = miro.x + dx[i];
				int ny = miro.y + dy[i];
				if(isRange(nx, ny, n, m) && !visit[ny][nx] && isGO(map[ny][nx])) {
					visit[ny][nx] = true;
					que.offer(new Miro(nx, ny, miro.distance + 1));
				}
			}
		}
		return -1;
	}

	private static boolean isGoal(int x, int y, int n, int m) {
		return x == m-1 && y == n-1;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

	private static boolean isGO(char c) {
		return c  == '1';
	}

}
