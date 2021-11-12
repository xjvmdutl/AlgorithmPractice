package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pipe{
	int x;
	int y;
	int dir;
	public Pipe(int x,int y,int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
public class 파이프옮기기1 {
	public static int[] dx = {1,0,1};
	public static int[] dy = {0,1,1};
	public static int[][] change = {{0,2},{1,2},{0,1,2}};
	public static int answer;
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
		if(map[n-1][n-1] == 1)
            return answer;
		bfs(map,n,1,0);
		return answer;
	}

	private static void bfs(int[][] map, int n, int x, int y) {
		Queue<Pipe> que = new LinkedList<>();
		que.offer(new Pipe(x, y, 0));
		while(!que.isEmpty()) {
			Pipe p = que.poll();
			if(p.x == n-1 && p.y == n-1) {
				answer++;
				continue;
			}
			int[] dirs = change[p.dir];
			OUTER:for(int i=0;i<dirs.length;++i) {
				int nx = p.x + dx[dirs[i]];
				int ny = p.y + dy[dirs[i]];
				if(isRange(nx,ny,n) && map[ny][nx] == 0) {
					if(dirs[i] == 2) {
						for(int j=0;j<2;++j) {
							int jx = p.x + dx[j];
							int jy = p.y + dy[j];
							if(!isRange(jx,jy,n) || map[jy][jx] != 0) {
								continue OUTER;
							}
						}
					}
					que.offer(new Pipe(nx,ny,dirs[i]));
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0<=nx&&nx<n&&0<=ny&&ny<n;
	}

}
