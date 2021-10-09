package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ·Îº¿Ã»¼Ò±â {
	public static int answer;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n,m,r,c,d));
	}

	private static int solution(int[][] map, int n, int m, int r, int c, int d) {
		answer = 0;
		clean(map,n,m,c,r,d);
		return answer;
	}

	private static void clean(int[][] map, int n, int m, int x, int y, int d) {
		if(map[y][x] == 0) {
			map[y][x] = 2;
			answer++;
		}
		boolean flag = false;
		int orgin = d;
		for(int i=0;i<4;++i) {
			int dir = (d+3)%4;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(isRange(nx,ny,n,m) && map[ny][nx] == 0) {
				flag = true;
				clean(map, n, m, nx, ny, dir);
				break;
			}
			d = (d+3) % 4;
		}
		if(!flag) {
			int dir = (orgin+2)%4;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(isRange(nx, ny, n, m) && map[ny][nx] != 1) {
				clean(map, n, m, nx, ny, orgin);
			}
		}
	}

	private static boolean isRange(int x, int y, int n, int m) {
		return 0 <= x && x < m && 0 <= y && y < n;
	}
	
}
