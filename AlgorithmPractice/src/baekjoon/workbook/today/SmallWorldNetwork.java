package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SmallWorldNetwork {
	private static final int INF = 101;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start][end] = 1;
			map[end][start] = 1;
		}
		System.out.println(solution(map, n ));
	}

	private static String solution(int[][] map, int n) {
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] >= 7) {
					return "Big World!"; 
				}
			}
		}
		
		return "Small World!";
	}
}
