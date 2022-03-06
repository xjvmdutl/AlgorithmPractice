package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Virus implements Comparable<Virus>{
	int x;
	int y;
	int number;
	public Virus(int x, int y, int number) {
		this.x = x;
		this.y = y;
		this.number = number;
	}
	@Override
	public int compareTo(Virus o) {
		return this.number - o.number;
	}
}
public class ∞Ê¿Ô¿˚¿¸ø∞ {
	public static boolean[][] visit;
	public static Queue<Virus> pq;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		tokens = new StringTokenizer(reader.readLine());
		int s = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken()) - 1;
		int y = Integer.parseInt(tokens.nextToken()) - 1;
		System.out.println(solution(map, n, k, s, x, y));
	}

	private static int solution(int[][] map, int n, int k, int s, int x, int y) {
		visit= new boolean[n][n];
		pq = new PriorityQueue<>();
		init(map, n);
		for(int i=0;i<s;++i) {
			spread(map, n);
		}
		return map[x][y];
	}

	private static void spread(int[][] map, int n) {
		Queue<Virus> que = new PriorityQueue<>();
		while(!pq.isEmpty()) {
			Virus v = pq.poll();
			for(int i=0;i<4;++i) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if(isRange(nx, ny, n) && map[ny][nx] == 0 && !visit[ny][nx]) {
					map[ny][nx] = v.number;
					que.offer(new Virus(nx, ny, map[ny][nx]));
					visit[ny][nx] = true;
				}
			}
		}
		pq = que;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

	private static void init(int[][] map, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] != 0) {
					pq.offer(new Virus(j, i, map[i][j]));
					visit[i][j] = true;
				}
			}	
		}
	}

}
