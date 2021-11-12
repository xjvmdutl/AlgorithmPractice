package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Shark implements Comparable<Shark>{
	int x;
	int y;
	int dis;
	public Shark(int x,int y,int dis) {
		this.dis = dis;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Shark o) {
		return this.dis - o.dis;
	}
}
public class 아기상어2 {
	public static boolean[][] visit;
	public static int[] dx = {-1,-1,0,1,1,1,0,-1};
	public static int[] dy = {0,-1,-1,-1,0,1,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(int[][] map, int n, int m) {
		int answer = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] == 0) {
					visit = new boolean[n][m];
					answer =Math.max(answer,  bfs(map,n,m,j,i));
				}
			}
		}
		return answer;
	}

	private static int bfs(int[][] map, int n, int m, int x, int y) {
		Queue<Shark> que = new PriorityQueue<>();
		que.offer(new Shark(x, y, 0));
		visit[y][x] = true;
		int count = 0;
		OUTER:while(!que.isEmpty()) {
			Shark s = que.poll();
			for(int i=0;i<8;++i) {
				int nx = s.x + dx[i];
				int ny = s.y + dy[i];
				if(isRange(nx,ny,n,m) && !visit[ny][nx] ) {
					if(map[ny][nx] == 0) {
						visit[ny][nx] = true;
						que.offer(new Shark(nx, ny, s.dis+1));
					}else {
						count = s.dis + 1;
						break OUTER;
					}
				}
			}
		}
		return count;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0<=nx&&nx<m&&0<=ny&&ny<n;
	}

}
