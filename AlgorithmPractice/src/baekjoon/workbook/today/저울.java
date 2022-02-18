package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Àú¿ï {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		boolean[][] map = new boolean[n][n];
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start][end] = true;
		}
		System.out.println(solution(map, n, m));
	}

	private static String solution(boolean[][] map, int n, int m) {
		StringBuilder sb = new StringBuilder();
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][k] && map[k][j]) {
						map[i][j] = true;
					}
				}
			}
		}
		for(int i=0;i<n;++i) {
			int count = 0;
			for(int j=0;j<n;++j) {
				if(i != j && (!map[i][j] && !map[j][i])) {
					count++;
				}
			}
			sb.append(count + "\n");
		}
		return sb.toString();
	}
}
