package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ºñ¼ó {
	public static int blackCount;
	public static int whiteCount;
	public static int[] dx = {-1,-1,1,1};
	public static int[] dy = {-1,1,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n ));
	}

	private static int solution(int[][] map, int n) {
		boolean[][] blackVisit = new boolean[n][n];
		boolean[][] whiteVisit = new boolean[n][n];
		blackCount= 0;
		whiteCount = 0;
        blackSearch(map, blackVisit, 0, 0, 0, n);
        whiteSearch(map, whiteVisit, 0, 1, 0, n);

		return blackCount + whiteCount;
	}

	private static void whiteSearch(int[][] map, boolean[][] whiteVisit, int y, int x, int count, int n) {
		whiteCount = Math.max(count, whiteCount);
        if(x >= n) {
            y += 1;
            x = (y%2 == 0)?1:0;
        }
		if(y >= n) {
			return;
		}
		if(isOkay(map, whiteVisit, y, x, n)) {
			whiteVisit[y][x] = true;
			whiteSearch(map, whiteVisit, y, x+2, count+1, n);
			whiteVisit[y][x] = false;
        }
		whiteSearch(map, whiteVisit, y, x+2, count, n);
	
	}

	private static void blackSearch(int[][] map, boolean[][] blackVisit, int y, int x, int count, int n) {
		blackCount = Math.max(count, blackCount);
        if(x >= n) {
            y += 1;
            x = (y%2 == 0)?0:1;
        }
		if(y >= n) {
			return;
		}
		if(isOkay(map, blackVisit, y, x, n)) {
			blackVisit[y][x] = true;
			blackSearch(map, blackVisit, y, x+2, count+1, n);
            blackVisit[y][x] = false;
        }
		blackSearch(map, blackVisit, y, x+2, count, n);
	}

	private static boolean isOkay(int[][] map, boolean[][] blackVisit, int y, int x, int n) {
		if(map[y][x] == 0) {
			return false;
		}
		OUTER:for(int i=0;i<4;++i) {
			for(int j=1;j<n;++j) {
				int nx = x + (dx[i] * j);
				int ny = y + (dy[i] * j);
				if(!isRange(nx, ny, n))
					continue OUTER;
				if(blackVisit[ny][nx])
					return false;
			}
		}
		return true;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
