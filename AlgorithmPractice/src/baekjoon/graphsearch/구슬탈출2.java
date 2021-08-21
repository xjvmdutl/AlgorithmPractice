package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point01{
	int x;
	int y;
	public Point01(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class ±∏ΩΩ≈ª√‚2 {
	
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static Point01 blue;
	public static int[][] visit;
	public static int answer;
	public static Queue<Point01> que;
	public static Point01 tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] arr = new char[n][m];
		for(int i=0;i<n;++i) {
			arr[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(arr,n,m));
	}
	private static int solution(char[][] arr, int n, int m) {
		answer = 0;
		visit =new int[n][m];
		que = new LinkedList<>();
		for(int i=1;i<n-1;++i) {
			for(int j=1;j<m-1;++j) {
				if(arr[i][j] == 'R') {
					que.offer(new Point01(j,i));
				}
				if(arr[i][j] == 'B') {
					blue = new Point01(j,i);
				}
			}
		}
		bfs(arr,n,m);
		if(answer == 0)
			return -1;
		return answer;
	}
	private static void bfs(char[][] arr, int n, int m) {
		
		while(!que.isEmpty()) {
			Point01 p = que.poll();
			for(int i=0;i<4;++i) {
				if(answer != 0) {
					return;
				}
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if(!isRange(arr,n,m,x,y)) continue;
				if(visit[y][x] == 0 && arr[y][x] != '#') {
					visit[p.y][p.x]++;
					tmp = null;
					goTo(arr,p.x,p.y,i);
					if(tmp != null) {
						que.offer(tmp);
					}
				}
			}
		}
	}
	private static void goTo(char[][] arr, int x, int y, int i) {
	    
		while(true) {
			if(arr[blue.y][blue.x] == 'O')
				return;
			if(arr[y][x] == 'O') {
				answer = visit[y][x];
				return;
			}
			if(arr[y+dy[i]][x+dx[i]] == '.' || arr[y+dy[i]][x+dx[i]] == 'O') {
				arr[y][x] = '.';
				x += dx[i];
				y += dy[i];
				arr[y][x] = 'R';
				visit[y][x] = visit[y-dy[i]][x-dx[i]];
			}
			if(arr[blue.y + dy[i]][blue.x + dx[i]] == '.' ) {
				arr[blue.y][blue.x] = '.';
				blue.x += dx[i];
				blue.y += dy[i];
				arr[blue.y][blue.x] = 'B';
			}
			if(arr[blue.y+dy[i]][blue.x+dx[i]] != '.' && arr[y+dy[i]][x+dx[i]] != '.') {
				tmp = new Point01(x, y);
				break;
			}
		}
	}
	private static boolean isRange(char[][] arr, int n, int m, int x, int y) {
		if(0 > x || x >= m || y < 0 || y>= n)
			return false;
		return true;
	}
	

}
