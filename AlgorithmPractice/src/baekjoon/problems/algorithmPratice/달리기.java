package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Runner implements Comparable<Runner>{
	int x;
	int y;
	int time;
	public Runner(int x,int y,int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
	@Override
	public int compareTo(Runner o) {
		return this.time - o.time;
	}
	
}
public class ´Þ¸®±â {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		visit = new int[n][m];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
			for(int j=0;j<m;j++) {
                visit[i][j] = Integer.MAX_VALUE;
            }
		}
		tokens = new StringTokenizer(reader.readLine());
		int y1 = Integer.parseInt(tokens.nextToken())-1;
		int x1 = Integer.parseInt(tokens.nextToken())-1;
		int y2 = Integer.parseInt(tokens.nextToken())-1;
		int x2 = Integer.parseInt(tokens.nextToken())-1;
		System.out.println(soltuon(map,n,m,k,x1,y1,x2,y2));
	}

	private static int soltuon(char[][] map, int n, int m, int k, int x1, int y1, int x2, int y2) {
		
		int answer = bfs(map,n,m,k,x1,y1,x2,y2);
		return answer;
	}

	private static int bfs(char[][] map, int n, int m, int k, int x1, int y1, int x2, int y2) {
		Queue<Runner> que = new PriorityQueue<>();
		que.offer(new Runner(x1, y1, 0));
		visit[y1][x1] = 0;
		while(!que.isEmpty()) {
			Runner r = que.poll();
			if(r.x == x2 && r.y == y2) {
				return r.time;
			}
			OUTER:for(int i=0;i<4;++i) {
				for(int j=1;j<=k;++j) {
					int nx = dx[i]*j + r.x;
					int ny = dy[i]*j + r.y;
					if(!isRange(nx,ny,n,m)  ) 
						continue OUTER;
					if(map[ny][nx] == '#' || visit[ny][nx] < visit[r.y][r.x]+1)
						continue OUTER;
					if(visit[ny][nx] == Integer.MAX_VALUE) {
						visit[ny][nx] =  r.time+1;
						que.offer(new Runner(nx, ny, r.time+1));
					}
				}
			}
			
		}
		return -1;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0<=nx&&nx<m&&0<=ny&&ny<n;
	}

}
