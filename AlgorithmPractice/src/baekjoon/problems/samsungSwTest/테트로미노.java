package baekjoon.problems.samsungSwTest;

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
		System.out.println(solution(map,n,m));
	}

	private static int solution(int[][] map, int n, int m) {
		answer = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				for(int k=0;k<5;++k) {
					findMax(map,n,m,i,j,k);
				}
			}
		}
		
		
		
		
		return answer;
	}

	private static void findMax(int[][] map, int n, int m, int y, int x, int k) {
		
		if(k == 0) {
			int sum = 0;
			int nx = x + 3;
			if(nx < m) {
				for(int i=x;i<=nx;++i)
					sum += map[y][i];
			}
			answer = Math.max(sum, answer);
			sum = 0;
			int ny = y + 3;
			if(ny < n) {
				for(int i=y;i<=ny;++i)
					sum += map[i][x];
			}
			answer = Math.max(sum, answer);
		}else if(k == 1) {
			int sum = 0;
			int nx = x + 1;
			int ny = y + 1;
			if(nx < m && ny < n) {
				sum += map[y][x];
				sum += map[y+1][x];
				sum += map[y][x+1];
				sum += map[y+1][x+1];
			}
			answer = Math.max(sum, answer);
		}else if(k == 2) {
			int sum = 0;
			int nx = x + 1;
			int ny = y + 2;
			if(nx < m && ny < n) {
				for(int i=y;i<=ny;++i) {
					for(int j=x;j<=nx;++j) {
						sum += map[i][j];
					}
				}
				answer = Math.max(sum - map[y][x] - map[y+1][x], answer);
				answer = Math.max(sum - map[y][x+1] - map[y+1][x+1], answer);
				answer = Math.max(sum - map[y+1][x] - map[y+2][x], answer);
				answer = Math.max(sum - map[y+1][x+1] - map[y+2][x+1], answer);
			}
			sum = 0;
			nx = x + 2;
			ny = y + 1;
			if(nx < m && ny < n) {
				for(int i=y;i<=ny;++i) {
					for(int j=x;j<=nx;++j) {
						sum += map[i][j];
					}
				}
				answer = Math.max(sum - map[y][x+1] - map[y][x+2], answer);
				answer = Math.max(sum - map[y+1][x+1] - map[y+1][x+2], answer);
				answer = Math.max(sum - map[y][x] - map[y][x+1], answer);
				answer = Math.max(sum - map[y+1][x] - map[y+1][x+1], answer);
			}
		}else if(k == 3) {
			int sum = 0;
			int nx = x + 1;
			int ny = y + 2;
			if(nx < m && ny < n) {
				for(int i=y;i<=ny;++i) {
					for(int j=x;j<=nx;++j) {
						sum += map[i][j];
					}
				}
				answer = Math.max(sum - map[y][x+1] - map[y+2][x], answer);
				answer = Math.max(sum - map[y][x] - map[y+2][x+1], answer);
			}
			sum = 0;
			nx = x + 2;
			ny = y + 1;
			if(nx < m && ny < n) {
				for(int i=y;i<=ny;++i) {
					for(int j=x;j<=nx;++j) {
						sum += map[i][j];
					}
				}
				answer = Math.max(sum - map[y][x] - map[y+1][x+2], answer);
				answer = Math.max(sum - map[y][x+2] - map[y+1][x], answer);
			}
		}else if(k == 4) {
			int sum = 0;
			int nx = x + 1;
			int ny = y + 2;
			if(nx < m && ny < n) {
				for(int i=y;i<=ny;++i) {
					for(int j=x;j<=nx;++j) {
						sum += map[i][j];
					}
				}
				answer = Math.max(sum - map[y][x] - map[y+2][x], answer);
				answer = Math.max(sum - map[y][x+1] - map[y+2][x+1], answer);
			}
			sum = 0;
			nx = x + 2;
			ny = y + 1;
			if(nx < m && ny < n) {
				for(int i=y;i<=ny;++i) {
					for(int j=x;j<=nx;++j) {
						sum += map[i][j];
					}
				}
				answer = Math.max(sum - map[y][x] - map[y][x+2], answer);
				answer = Math.max(sum - map[y+1][x] - map[y+1][x+2], answer);
			}
		}
	}

}
