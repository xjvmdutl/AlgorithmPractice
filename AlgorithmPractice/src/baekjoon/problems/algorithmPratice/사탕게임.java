package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ªÁ≈¡∞‘¿” {
	public static int[] dx = {-1,1,0,0};
	public static int answer;
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[][] map = new char[n][n];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map,n));
	}

	private static int solution(char[][] map, int n) {
		answer = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				char c = map[i][j];
				for(int k=0;k<4;++k) {
					int nx = j + dx[k];
					int ny = i + dy[k];
					if(isRange(nx,ny,n) && c != map[ny][nx]) {
						swap(map,j,i,nx,ny);
						answer = Math.max(answer,check(map));
						swap(map,nx,ny,j,i);
					}
				}
			}
		}
		
		
		return answer;
	}

	private static int check(char[][] map) {
		int n = map.length;
		int ans = 1;
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 1; j < n; j++) {
				if (map[i][j] == map[i][j - 1]) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				if (ans < cnt)
					ans = cnt;
			}
			cnt = 1;
			for (int j = 1; j < n; j++) {
				if (map[j][i] == map[j - 1][i]) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				if (ans < cnt)
					ans = cnt;
			}
		}
		return ans;
	}

	private static void swap(char[][] map, int x, int y, int nx, int ny) {
		char tmp = map[y][x];
		map[y][x] = map[ny][nx];
		map[ny][nx] = tmp;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
