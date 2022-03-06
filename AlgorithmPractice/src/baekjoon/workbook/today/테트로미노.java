package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
	public static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(int[][] map, int n, int m) {
		answer = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				find(map, n, m, j, i);
			}
		}
		return answer;
	}

	private static void find(int[][] map, int n, int m, int x, int y) {
		first(map, n, m, x, y);
		second(map, n, m, x, y);
		third(map, n, m, x, y);
		fourth(map, n, m, x, y);
		fifth(map, n, m, x, y);
	}

	private static void fifth(int[][] map, int n, int m, int x, int y) {
		int[][][] dx = {
				{{0,1,1,2}, {0,1,1,2}}
				,{{0,0,-1,0}, {0,0,1,0}}
				,{{0,-1,-1,-2}, {0,-1,-1,-2}}
				,{{0,0,1,0}, {0,0,-1,0}}
				};
		int[][][] dy = {
				 {{0,0,1,0}, {0,0,-1,0}}
				,{{0,1,1,2}, {0,1,1,2}}
				,{{0,0,-1,0}, {0,0,1,0}}
				,{{0,-1,-1,-2}, {0,-1,-1,-2}}
				};
		
		for(int i=0;i<4;++i) {
			OUTER:for(int j=0;j<2;++j) {
				int sum = 0;
				for(int k=0;k<4;++k) {
					int nx = x + dx[i][j][k];
					int ny = y + dy[i][j][k];
					if(!isRange(nx, ny, n, m)) {
						continue OUTER;
					}
					sum += map[ny][nx];
				}
				answer = Math.max(answer, sum);
			}
		}
	}

	private static void fourth(int[][] map, int n, int m, int x, int y) {
		int[][][] dx = {
				{{0,0,1,1}, {0,0,-1,-1}}
				,{{0,-1,-1,-2}, {0,-1,-1,-2}}
				,{{0,0,-1,-1}, {0,0,1,1}}
				,{{0,1,1,2}, {0,1,1,2}}
				};
		int[][][] dy = {
				 {{0,1,1,2}, {0,1,1,2}}
				,{{0,0,1,1}, {0,0,-1,-1}}
				,{{0,-1,-1,-2}, {0,-1,-1,-2}}
				,{{0,0,-1,-1}, {0,0,1,1}}
				};
		
		for(int j=0;j<2;++j) {
			OUTER:for(int i=0;i<4;++i) {
				int sum = 0;
				for(int k=0;k<4;++k) {
					int nx = x + dx[i][j][k];
					int ny = y + dy[i][j][k];
					if(!isRange(nx, ny, n, m)) {
						continue OUTER;
					}
					sum += map[ny][nx];
				}
				answer = Math.max(answer, sum);
			}
		}
	}

	private static void third(int[][] map, int n, int m, int x, int y) {
		int[][][] dx = {
				{{0,0,0,1}, {0,0,0,-1}}
				,{{0,-1,-2,-2}, {0,-1,-2,-2}}
				,{{0,0,0,-1}, {0,0,0,1}}
				,{{0,1,2,2}, {0,1,2,2}}
				};
		int[][][] dy = {
				 {{0,1,2,2}, {0,1,2,2}}
				,{{0,0,0,1}, {0,0,0,-1}}
				,{{0,-1,-2,-2}, {0,-1,-2,-2}}
				,{{0,0,0,-1}, {0,0,0,1}}
				};
		for(int i=0;i<4;++i) {
			OUTER:for(int j=0;j<2;++j) {
				int sum = 0;
				for(int k=0;k<4;++k) {
					int nx = x + dx[i][j][k];
					int ny = y + dy[i][j][k];
					if(!isRange(nx, ny, n, m)) {
						continue OUTER;
					}
					sum += map[ny][nx];
				}
				answer = Math.max(answer, sum);
			}
		}
	}

	private static void second(int[][] map, int n, int m, int x, int y) {
		int sum = 0;
		if(isRange(x+1, y+1, n, m)) {
			sum += map[y][x];
			sum += map[y][x+1];
			sum += map[y+1][x];
			sum += map[y+1][x+1];
			answer = Math.max(sum, answer);
		}

	}

	private static void first(int[][] map, int n, int m, int x, int y) {
		if(isRange(x+3, y, n, m)) {
			int sum = 0;
			for(int i=0;i<4;++i) {
				sum += map[y][x+i];
			}
			answer = Math.max(sum, answer);
		}
		if(isRange(x, y+3, n, m)) {
			int sum = 0;
			for(int i=0;i<4;++i) {
				sum += map[y+i][x];
			}
			answer = Math.max(sum, answer);

		}
	}

	private static boolean isRange(int x, int y, int n, int m) {
		return 0 <= x && x < m && 0 <= y && y < n;
	}

}
