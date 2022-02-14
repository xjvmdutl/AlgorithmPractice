package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Texi implements Comparable<Texi>{
	int x;
	int y;
	int dis;
	public Texi(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Texi(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
	@Override
	public int compareTo(Texi o) {
		if(o.dis == this.dis) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
		return this.dis - o.dis;
	}
}
public class 스타트택시 {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer;
	public static Map<Integer, Texi> datas;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		datas = new HashMap<>();
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		tokens = new StringTokenizer(reader.readLine());
		Texi start = new Texi(Integer.parseInt(tokens.nextToken()) - 1, Integer.parseInt(tokens.nextToken()) - 1);
		for(int i=1;i<=m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			Texi s = new Texi(Integer.parseInt(tokens.nextToken()) - 1, Integer.parseInt(tokens.nextToken()) - 1);
			Texi e = new Texi(Integer.parseInt(tokens.nextToken()) - 1, Integer.parseInt(tokens.nextToken()) - 1);
			map[s.x][s.y] = -i;
			datas.put(-i, e);
		}
		System.out.println(solution(map, start, n,m,k));
		
	}

	private static int solution(int[][] map, Texi start, int n, int m, int k) {
		answer = -1;
		int count = 0;
		while(true) {
			if(count++ == m)
				break;
			Texi t = find(map, start, n, k);
			if(t == null)
				return -1;
			Texi goal = datas.get(map[t.x][t.y]);
			int distance = bfs(map, t, goal, n);
			if(distance == 0)
				return -1;
			if(k < distance + t.dis) {
				return -1;
			}
			k -= t.dis + distance;
			k += distance*2;
			map[t.x][t.y] = 0; 
			start = goal;
		}
		return k;
	}

	private static int bfs(int[][] map, Texi start, Texi goal, int n) {
		visit = new boolean[n][n];
		Queue<Texi> pq = new PriorityQueue<>();
		pq.offer(new Texi(start.x, start.y, 0));
		visit[start.x][start.y] = true; 
		while(!pq.isEmpty()) {
			Texi t = pq.poll();
			if(t.x == goal.x && t.y == goal.y) {
				return t.dis;
			}
			for(int i=0;i<4;++i) {
				int nx = dx[i] + t.x;
				int ny = dy[i] + t.y;
				if(isRange(nx,ny,n) && !visit[nx][ny] && map[nx][ny] != 1) {
					visit[nx][ny] = true;
					pq.offer(new Texi(nx, ny, t.dis + 1));
				}
			}
		}
		return 0;
	}

	private static Texi find(int[][] map, Texi start, int n, int k) {
		visit = new boolean[n][n];
		Queue<Texi> pq = new PriorityQueue<>();
		pq.offer(new Texi(start.x, start.y, 0));
		visit[start.x][start.y] = true; 
		while(!pq.isEmpty()) {
			Texi t = pq.poll();
			if(map[t.x][t.y] < 0) {
				return new Texi(t.x, t.y, t.dis);
			}
			for(int i=0;i<4;++i) {
				int nx = dx[i] + t.x;
				int ny = dy[i] + t.y;
				if(isRange(nx,ny,n) && !visit[nx][ny] && map[nx][ny] != 1) {
					visit[nx][ny] = true;
					pq.offer(new Texi(nx, ny, t.dis + 1));
				}
			}
		}
		return null;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
