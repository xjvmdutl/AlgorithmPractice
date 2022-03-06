package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 원판돌리기 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean isOkay;
	public static boolean[][] visit;
	public static int sum;
	public static int cnt;
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
			solution(map, n, m, x, d, k);
		}
			
		System.out.println(counting(map, n, m));
	}

	private static int counting(int[][] map, int n, int m) {
		sum = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				sum += map[i][j];
			}	
		}
		return sum;
	}

	private static void solution(int[][] map, int n, int m, int x, int d, int k) {
		for(int i=x-1;i<map.length;i+=x) {
			map[i] = Circle(map, i, d, k);
		}
		visit = new boolean[n][m];
		isOkay = false;
		cnt = 0;
		sum = 0;
		calc(map, n, m);
		if(isOkay) {
			remove(map,n,m);
		}else {
			averageCalc(map, n, m);
		}
	}

	private static void averageCalc(int[][] map, int n, int m) {
		double avg = (double)sum / cnt;
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] != 0 && map[i][j] > avg) {
					map[i][j]--;
				}else if(map[i][j] != 0 && map[i][j] < avg) {
					map[i][j]++;
				}
			}	
		}
	}

	private static void calc(int[][] map, int n, int m) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] != 0) {
					cnt++;
					sum+=map[i][j];
					find(map, i, j, n, m);
				}
			}	
		}
	}

	private static void remove(int[][] map, int n, int m) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(visit[i][j]) {
					map[i][j] = 0;
				}
			}	
		}
	}

	private static void find(int[][] map, int y, int x,int n, int m) {
		for(int i=0;i<4;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 ) {
				nx = m-1;
			}else if(nx > n) {
				nx = nx % m;
			}
			if(isRange(nx, ny, n, m) && map[y][x] == map[ny][nx]) {
				isOkay = true;
				visit[ny][nx] = true;
				visit[y][x] = true;
			}
			
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny & ny < n;
	}

	private static int[] Circle(int[][] map, int index, int d, int k) {
		int length = map[index].length;
		int[] tmp = new int[length];
		for(int i=0;i<length;++i) {
			if(d == 0) {
				int now = (i-k) < 0 ? (i-k) + length : i-k;
				tmp[i] = map[index][now];
			}else {
				tmp[i] = map[index][(i+k)%length];
			}
		}
		return tmp;
	}

}
