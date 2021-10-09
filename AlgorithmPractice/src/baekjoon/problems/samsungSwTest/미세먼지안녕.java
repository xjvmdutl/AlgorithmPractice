package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 미세먼지안녕 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int t = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[r][c];
		for(int i=0;i<r;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<c;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,r,c,t));
	}

	private static int solution(int[][] map, int r, int c, int t) {
		while(t-- > 0) {
			map = flush(map,r,c,t);
			for(int i=0;i<r;++i) {
				if(map[i][0] == -1) {
					upperGo(map,r,c,i);
					underGo(map,r,c,i+1);
					break;
				}
			}
			
		}
		int answer = 0;
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(map[i][j] != -1) {
					answer += map[i][j];
				}
			}	
		}
		return answer;
	}

	private static void underGo(int[][] map, int r, int c, int now) {
		for(int i=now+1;i < r-1;++i) {
			map[i][0] = map[i+1][0];
		}
		for(int i=0;i<c-1;++i) {
			map[r-1][i] = map[r-1][i+1];
		}
		for(int i=r-1;i>now;--i) {
			map[i][c-1] = map[i-1][c-1];
		}
		for(int i=c-1;i>1;--i) {
			map[now][i] = map[now][i-1];
		}
		map[now][1] = 0;
	}

	private static void upperGo(int[][] map, int r, int c, int now) {
		for(int i=now - 1;i>0;--i) {
			map[i][0] = map[i-1][0];
		}
		for(int i=0;i<c-1;++i) {
			map[0][i] = map[0][i+1];
		}
		for(int i=0;i<now;++i) {
			map[i][c-1] = map[i+1][c-1];
		}
		for(int i=c-1;i>1;--i) {
			map[now][i] = map[now][i-1];
		}
		map[now][1] = 0;
	}

	private static int[][] flush(int[][] map, int r, int c, int t) {
		int[][] tmp = new int[r][c];
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if (map[i][j] > 0) {
					int count = 0;
					int num = map[i][j]/5;
					for(int k=0;k<4;++k) {
						int nx = dx[k] + j;
						int ny = dy[k] + i;
						if(isRange(nx,ny,r,c) && map[ny][nx] != -1) {
							tmp[ny][nx] += num;
							count++;
						}
					}
					tmp[i][j] += map[i][j] - count*num;
				}else if(map[i][j] == -1) {
					tmp[i][j] = map[i][j];
				}
			}	
		}
		return tmp;
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0<= nx && nx < c && ny < r && 0 <= ny;
	}

}
