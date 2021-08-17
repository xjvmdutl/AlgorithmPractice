package backJun.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Wall implements Comparable<Wall>{
	int x;
	int y;
	int fireWall;
	public Wall(int x,int y,int fireWall) {
		this.x = x;
		this.y = y;
		this.fireWall = fireWall;
	}
	@Override
	public int compareTo(Wall o) {
		return this.fireWall - o.fireWall;
	}
}
public class ¾Ë°í½ºÆÌ {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visit;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][m];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<m;++j) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		System.out.println(solution(arr,n,m));
	}

	private static int solution(int[][] arr, int n, int m) {
		answer = 0;
		visit = new boolean[n][m];
		bfs(arr,n,m);
		return answer;
	}

	private static void bfs(int[][] arr, int n, int m) {
		Queue<Wall> que = new PriorityQueue<>();
		que.offer(new Wall(0,0,0));
		visit[0][0] = true;
		while(!que.isEmpty()) {
			Wall w = que.poll();
			if(w.x == m-1 && w.y == n-1) {
				answer = w.fireWall;
				break;
			}
			for(int i=0;i<4;++i) {
				int x = dx[i] + w.x;
				int y = dy[i] + w.y;
				if(0 <= x  && x < m && 0 <= y && y < n) {
					if(!visit[y][x]) {
						int fireWall = w.fireWall;
						if(arr[y][x] == 1) {
							visit[y][x] = true; 
							fireWall++;
						}else if(arr[y][x] == 0) {
							visit[y][x] = true;
						}
						que.offer(new Wall(x,y,fireWall));
					}
				}
			}
		}
	}

}
