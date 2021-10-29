package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class º½¹ö¸Ç {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean[][] visit;
	public static int[][] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[r][c];
		for(int i=0;i<r;++i) {
			String str = reader.readLine();
			for(int j=0;j<c;++j) {
				if(str.charAt(j) == 'O') {
					map[i][j] = 3;
				}else {
					map[i][j] = 0;
				}
			}
		}
		System.out.println(solution(map,r,c,n));
	}

	private static String solution(int[][] map, int r, int c, int n) {
		
		for(int i=1;i<=n;++i) {
			visit = new boolean[r][c];
			tmp = new int[r][c];
			go(map,r,c);
			map = fire(map,r,c);
			if(i % 2 == 0) {
				spred(map, r, c);
			}
		}
		return print(map,r,c);
	}

	private static int[][] fire(int[][] map, int r, int c) {
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(map[i][j] == 0 && visit[i][j]) {
					int x = j;
					int y = i;
					for(int k=0;k<4;++k) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if(isRange(nx,ny,r,c)) {
							tmp[ny][nx] = 0;
						}
					}
				}
			}
		}
		return tmp;
	}

	private static void go(int[][] map, int r, int c) {
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(map[i][j] != 0) {
					visit[i][j] = true;
					map[i][j]--;
				}
				tmp[i][j] = map[i][j];
			}
		}
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny && ny < r;
	}

	private static void spred(int[][] map, int r, int c) {
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(map[i][j] == 0) {
					map[i][j] = 3;
				}
			}
		}
	}

	private static String print(int[][] map, int r, int c) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(map[i][j] == 0)
					sb.append('.');
				else
					sb.append('O');
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
