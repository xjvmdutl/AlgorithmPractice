package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class NM°úK1 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer;
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map, n, m, k));
	}

	private static int solution(int[][] map, int n, int m, int k) {
		answer = Integer.MIN_VALUE;
		Point[] select = new Point[k];
		visit = new boolean[n][m];
		permulate(map,select,n,m,0,k);
		return answer;
	}

	private static void permulate(int[][] map, Point[] select, int n, int m, int count, int k) {
		if(count == k) {
			int sum = 0;
			for(Point p : select) {
				sum += map[p.y][p.x];
			}
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(!visit[i][j] && isOkay(i,j,n,m)) {
					visit[i][j] = true;
					select[count] = new Point(j,i);
					permulate(map,select, n, m, count+1, k);
					visit[i][j] = false;
				}
			}	
		}
		
	}

	private static boolean isOkay(int y, int x,int n, int m) {
		for(int i=0;i<4;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx, ny, n, m) && visit[ny][nx]) {
				return false;
			}
		}
		return true;
	}


	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0<=nx && nx < m && 0<= ny && ny < n;
	}

}
