package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n, m, r));
	}

	private static String solution(int[][] map, int n, int m, int r) {
		int groupValue = Math.min(n, m) / 2;
		for(int j=0;j<r;++j) {
			for(int i=0;i<groupValue;++i) {
				rotation(map, i, n, m);
			}
		}
		
		
		return print(map, n, m);
	}
	
	

	private static void rotation(int[][] map, int i, int n, int m) {
		int x = i;
		int y = i;
		int value = map[y][x];
		int dir = 0;
		while(dir < 4) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(isRange(nx, ny, n, m, i)) {
				map[y][x] = map[ny][nx];
				x = nx;
				y = ny;
			}else {
				dir++;
			}
		}
		map[i + 1][i] = value;
	}

	private static boolean isRange(int nx, int ny, int n, int m, int i) {
		return i <= nx && nx < m-i && i <= ny && ny < n - i;
	}

	private static int modR(int r, int count) {
		return r % count;
	}

	private static String print(int[][] map, int n, int m) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				answer.append(map[i][j] + " ");
			}	
			answer.append("\n");
		}
		return answer.toString();
	}

}
