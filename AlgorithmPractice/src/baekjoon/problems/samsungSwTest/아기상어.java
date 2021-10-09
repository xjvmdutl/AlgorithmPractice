package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Shark{
	int x;
	int y;
	int dis;
	public Shark(int x,int y,int dis) {
		this.dis = dis;
		this.x = x;
		this.y = y;
	}
}
public class 아기상어 {
	public static int answer;
	public static int eatCount;
	public static int babyShark;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n));
	}

	private static int solution(int[][] map, int n) {
		answer = 0;
		babyShark = 2;
		eatCount = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] == 9) {
					map[i][j] = 0;
					bfs(map,n,j,i);
				}
			}
		}
		return answer;
	}

	private static void bfs(int[][] map, int n, int x, int y) {
		Queue<Shark> que = new LinkedList<>();
		Queue<Shark> pq = new PriorityQueue<>((o1,o2)->{
			if(o1.dis == o2.dis) {
				if(o1.y == o2.y)
					return o1.x - o2.x;
				return o1.y - o2.y;
			}
			return o1.dis - o2.dis;
		}); 
		boolean[][] visit = new boolean[n][n];
		visit[y][x] = true;
		que.offer(new Shark(x, y, 0));
		while(!que.isEmpty()) {
			Shark s = que.poll();
			for(int i=0;i<4;++i) {
				int nx = s.x + dx[i];
				int ny = s.y + dy[i];
				if(0 <= nx && nx <n && 0<= ny && ny < n) {
					if(!visit[ny][nx]) {
						if(map[ny][nx] == 0 || map[ny][nx] == babyShark) {
							que.offer(new Shark(nx, ny, s.dis+1));
							visit[ny][nx] = true;
						}else if(map[ny][nx] >= 1 && map[ny][nx] < babyShark) {
							visit[ny][nx] = true;
							que.offer(new Shark(nx, ny, s.dis+1));
							pq.offer(new Shark(nx, ny, s.dis+1));
						}
					}
				}
			}
		}
		if(pq.isEmpty()) {
			return;
		}
		Shark shark = pq.poll();
		map[shark.y][shark.x] = 0;
		eatCount++;
		if(babyShark == eatCount) {
			eatCount = 0;
			babyShark++;
		}
		answer += shark.dis;
		bfs(map, n, shark.x, shark.y);
	}

}
