package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Groom{
	int x;
	int y;
	public Groom(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class 마법사상어와비바라기 {
	public static List<Groom> list;
	public static boolean[][] visit;
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		int[][] arr = new int[m][2];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken()) - 1;
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map, arr, n, m));
	}

	private static int solution(int[][] map, int[][] arr, int n, int m) {
		list = new ArrayList<Groom>();
		//N, 1), (N, 2), (N-1, 1), (N-1, 2)
		list.add(new Groom(0, n-2));
		list.add(new Groom(0, n-1));
		list.add(new Groom(1, n-2));
		list.add(new Groom(1, n-1));
		for(int i=0;i<m;++i) {
			visit = new boolean[n][n];
			move(map, arr[i][0], arr[i][1], n);
			addGroom(map, n);
		}
		int answer = counting(map, n);
		return answer;
	}

	private static void move(int[][] map, int d, int s, int n) {
		List<Groom> moveList = new ArrayList<Groom>();
		for(Groom g : list) {
			s %= n;
			int nx;
			int ny;
			if( s == 0) {
				nx = g.x;
				ny = g.y;
			}else {
				nx = (g.x + (dx[d] * s) >= 0 ? 
						g.x + (dx[d] * s)
						: n + (g.x + (dx[d] * s)))% n;
				ny = (g.y + (dy[d] * s) >= 0 ? 
						g.y + (dy[d] * s)
						: n + (g.y + (dy[d] * s)))% n;
			}
			map[ny][nx]++; 
			moveList.add(new Groom(nx, ny));
		}
		list.clear();
		failGroom(map, moveList, n);
	}

	private static void addGroom(int[][] map, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] >= 2 && !visit[i][j]) {
					list.add(new Groom(j, i));
					map[i][j]-=2;
				}
			}
		}
	}

	private static void failGroom(int[][] map, List<Groom> moveList, int n) {
		for(Groom g : moveList) {
			visit[g.y][g.x] = true; 
			int count = 0;
			for(int i=1;i<=7;i+=2) {
				int nx = g.x + dx[i];
				int ny = g.y + dy[i];
				if(isRange(nx, ny, n) && map[ny][nx] > 0) {
					count++;
				}
			}
			map[g.y][g.x] += count;
		}
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

	private static int counting(int[][] map, int n) {
		int sum = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				sum += map[i][j];
			}	
		}
		return sum;
	}

}
