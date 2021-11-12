package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Garbage{
	int x;
	int y;
	public Garbage(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 음식물피하기 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) 
			for(int j=0;j<m;++j)
				map[i][j] = '.';
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(tokens.nextToken())-1;
			int x = Integer.parseInt(tokens.nextToken())-1;
			map[y][x] = '#';
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(char[][] map, int n, int m) {
		int answer = 0;
		visit = new boolean[n][m];
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(!visit[i][j] && map[i][j] == '#') {
					answer = Math.max(answer, bfs(map,j,i,n,m));
				}
			}
		}
		return answer;
	}

	private static int bfs(char[][] map, int x, int y, int n, int m) {
		Queue<Garbage> que = new LinkedList<>();
		que.offer(new Garbage(x, y));
		visit[y][x] = true;
		int size = 0;
		while(!que.isEmpty()) {
			Garbage g = que.poll();
			size++;
			for(int i=0;i<4;++i) {
				int nx = dx[i] + g.x;
				int ny = dy[i] + g.y;
				if(isRange(nx,ny,n,m) && !visit[ny][nx] && map[ny][nx] == '#') {
					que.offer(new Garbage(nx, ny));
					visit[ny][nx] = true;
				}
			}
		}
		return size;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0<=nx&&nx<m&&0<=ny&&ny<n;
	}

}
