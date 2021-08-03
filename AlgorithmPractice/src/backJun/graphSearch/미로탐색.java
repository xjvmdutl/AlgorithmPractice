package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point{
	int x;
	int y;
	public point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class 미로탐색 {
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer = 0;
	public static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][m];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<m;++j) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		System.out.println(solution(arr,n,m));
	}
	/* 
	//  dfs는 시간초과 -> bfs로 풀어야된다.
	private static int solution(int[][] arr, int n, int m) {
		answer = Integer.MAX_VALUE;
		point p = new point(0, 0);
		visited = new boolean[n][m];
		visited[0][0] = true;
		dfs(arr,n-1,m-1,p,0);
		
		return answer;
	}

	private static void dfs(int[][] arr, int n, int m,point p,int cnt) {
		if(p.y == n && p.x == m) {
			answer = Math.min(answer,cnt+1);
			return;
		}
		for(int i=0;i<4;++i) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			if(0 <= y && y <= n && 0 <= x && x <= m) {
				if(arr[y][x] == 1 && !visited[y][x]) {
					point ptr = new point(x, y);
					cnt++;
					visited[y][x] = true;
					dfs(arr,n,m,ptr,cnt);
					visited[y][x] = false;
					cnt--;
				}
			}
		}
		
	}
	*/
	private static int solution(int[][] arr, int n, int m) {
		answer = Integer.MAX_VALUE;
		
		visited = new int[n][m];
		visited[0][0] = 1;
		bfs(arr,n-1,m-1);
		answer = visited[n-1][m-1];
		return answer;
	}

	private static void bfs(int[][] arr, int n, int m) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(0, 0));
		while(!queue.isEmpty()) {
			point ptr = queue.poll();
			for(int i=0;i<4;++i) {
				
				int x = ptr.x + dx[i];
				int y = ptr.y + dy[i];
				if(0 <= y && y <= n && 0 <= x && x <= m) {
					if(arr[y][x] == 1 && visited[y][x] == 0) {
						point p = new point(x, y);
						
						int d = visited[ptr.y][ptr.x];
						visited[y][x] = d+1;
						if(p.y == n && p.x == m) {
							return;
						}
						queue.offer(p);
					}
					
				}
			}
		}
	}
}
