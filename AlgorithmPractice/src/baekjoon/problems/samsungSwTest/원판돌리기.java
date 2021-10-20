package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원판돌리기 {
	public static boolean[][] remove;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int t = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		for(int i=0;i<t;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int k = Integer.parseInt(tokens.nextToken()); 
			solution(map,n,m,x,d,k);
		}
		System.out.println(totalSum(map,n,m));
		
	}

	private static void solution(int[][] map, int n, int m, int x, int d, int k) {
		remove = new boolean[n][m];
		for(int now = x-1;now<map.length;now+=x) {
			if(d == 0) {
				for(int j=0;j<k;++j) {
					int last = map[now][m-1];
					for(int i=m-1;i>0;--i) {
						map[now][i] = map[now][i-1];
					}
					map[now][0] = last;
				}
			}else {
				for(int j=0;j<k;++j) {
					int first = map[now][0];
					for(int i=1;i<m;++i) {
						map[now][i-1] = map[now][i];
					}
					map[now][m-1] = first;
				}
			}
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				find(map,i,j,n,m);
			}	
		}
		boolean flag = true;
		int count = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(remove[i][j]) {
					flag = false;
					map[i][j] = 0;
				}
				if(map[i][j] != 0) {
					count++;
				}
			}	
		}
		if(flag) {
			double number = (double)totalSum(map,n,m)/count;
			for(int i=0;i<n;++i) {
				for(int j=0;j<m;++j) {
					if(map[i][j] != 0) {
						if(map[i][j] > number)
							map[i][j]--;
						else if(map[i][j] < number)
							map[i][j]++;
					}
				}	
			}
		}
	}

	private static void find( int[][] map, int y, int x, int n, int m) {
		if(map[y][x] == 0)
			return;
		int now = map[y][x];
		for(int i=0;i<4;++i) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx < 0)
				nx = m-1;
			else
				nx = nx%m;
			if(isRange(nx,ny,n,m) && map[ny][nx] == now) {
				remove[ny][nx] = true;
				remove[y][x] = true;
			}
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0<=nx&&nx<m&&0<=ny&&ny<n;
	}

	private static int totalSum(int[][] map,int n,int m) {
		int sum = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				sum += map[i][j];
			}
		}
		return sum;
	}

}
