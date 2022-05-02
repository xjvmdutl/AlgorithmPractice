package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n, m, r));
	}

	private static String solution(int[][] map, int n, int m, int r) {
		int min = Math.min(n, m);
		for(int i=0;i<min/2;++i) {
			int startRow = i;
			int startCol = i;
			int endRow = n - i - 1;
			int endCol = m - i - 1;
			int count = (endRow - startRow + 1) * (endCol - startCol + 1);
			int cnt = modR(r, count);
			for(int j=0;j<cnt;++j) {
				rotation(map, startRow, startCol, endRow, endCol);
			}
		}
		
		return print(map, n, m);
	}
	
	

	private static int modR(int r, int count) {
		return r % count;
	}

	private static void rotation(int[][] map, int startRow, int startCol, int endRow, int endCol) {
		int start = map[startRow][startCol];
		leftStartRow(map[startRow], startCol, endCol);
		upEndCol(map, startRow, endRow, endCol);
		rightEndRow(map[endRow], startCol, endCol);
		underStartCol(map, startRow, endRow, startCol);
		
		map[startRow+1][startCol] = start;
	}
	

	private static void leftStartRow(int[] map, int startCol, int endCol) {
		for(int i=startCol;i<endCol;++i) {
			map[i] = map[i+1];
		}
	}

	private static void upEndCol(int[][] map, int startRow, int endRow, int endCol) {
		for(int i=startRow;i<endRow;++i) {
			map[i][endCol] = map[i+1][endCol];
		}
	}
	
	private static void rightEndRow(int[] map, int startCol, int endCol) {
		for(int i=endCol;i>startCol;--i) {
			map[i] = map[i-1];
		}
	}
	
	private static void underStartCol(int[][] map, int startRow, int endRow, int startCol) {
		for(int i=endRow;i>startRow;--i) {
			map[i][startCol] = map[i-1][startCol];
		}
	}

	private static String print(int[][] map, int n, int m) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				answer.append(map[i][j] + " ");
			}	
			answer.append("\n");
		}
		return answer.toString();
	}

}
