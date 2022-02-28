package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그림비교 {
	public static int min;
	public static int[] minIdx;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[][][] map = new char[n][5][7];
		for(int i=0;i<n;++i) {
			for(int j=0;j<5;++j) {
				map[i][j] = reader.readLine().toCharArray();
			}
		}
		System.out.println(solution(map, n));
	}

	private static String solution(char[][][] map, int n) {
		min = Integer.MAX_VALUE;
		minIdx = new int[2];
		for(int i=0;i<n;++i) {
			char[][] now = map[i];
			for(int j = i+1; j< n; ++j) {
				char[][] next = map[j];
				compare(now, next, n, i , j);
			}
		}
		StringBuilder sb= new StringBuilder();
		sb.append((minIdx[0]+1) + " " + (minIdx[1] + 1));
		return sb.toString();
	}

	private static void compare(char[][] now, char[][] next, int n, int first, int second) {
		int count = 0;
		for(int i=0;i<now.length;++i) {
			for(int j=0;j<now[i].length;++j) {
				if(now[i][j] != next[i][j]) {
					count++;
				}
			}	
		}
		if(count < min) {
			min = count;
			minIdx[0] = first;
			minIdx[1] = second;
		}
	}

}
