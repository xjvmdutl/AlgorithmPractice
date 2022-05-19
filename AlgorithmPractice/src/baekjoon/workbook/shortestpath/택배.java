package baekjoon.workbook.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ец╧Х {
	private static final int INF = 10001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = getMap(n);
		int[][] result = new int[n][n];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken()) ;
			int time = Integer.parseInt(tokens.nextToken());
			map[start - 1][end - 1] = map[end - 1][start - 1] = time;
			result[start - 1][end - 1]= end;			
			result[end - 1][start - 1] = start;
		}
		System.out.println(solution(map, result, n, m));
	}

	private static int[][] getMap(int n) {
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		return map;
	}
	
	private static String solution(int[][] map, int[][] result, int n, int m) {
		floydWhashal(map, result, n);
		return getResult(result, n);
	}

	private static void floydWhashal(int[][] map, int[][] result, int n) {
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						result[i][j] = result[i][k]; 
					}
				}	
			}	
		}
	}

	private static String getResult(int[][] result, int n) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(result[i][j] == 0) {
					answer.append("- ");	
				}else {
					answer.append(result[i][j]  + " ");
				}
			}	
			answer.append("\n");
		}
		return answer.toString();
	}
}
