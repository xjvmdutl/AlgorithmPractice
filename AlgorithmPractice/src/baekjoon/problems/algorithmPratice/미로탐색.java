package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Miro implements Comparable<Miro>{
	int x;
	int y;
	int dis;
	public Miro(int x,int y,int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
	@Override
	public int compareTo(Miro o) {
		return this.dis - o.dis;
	}
	
}
public class ¹Ì·ÎÅ½»ö {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map,n,m));
		
	}

	private static int solution(char[][] map, int n, int m) {
		answer = 0;
		visit = new boolean[n][m];
		bfs(map,n,m);
		return answer;
	}

	private static void bfs(char[][] map, int n, int m) {
		Queue<Miro> pq = new PriorityQueue<>();
		visit[0][0] = true;
		pq.offer(new Miro(0, 0, 1));
		while(!pq.isEmpty()) {
			Miro miro = pq.poll();
			if(miro.x == m-1 && miro.y == n-1) {
				answer = miro.dis;
				return;
			}
			for(int i=0;i<4;++i) {
				int nx = miro.x + dx[i];
				int ny = miro.y + dy[i];
				if(isRange(nx,ny,n,m) && !visit[ny][nx] && map[ny][nx] == '1') {
					pq.offer(new Miro(nx, ny, miro.dis+1));
					visit[ny][nx] = true;
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0<=nx&&nx<m&&0<=ny&&ny<n;
	}

}
