package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ец╧Х {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		int[][] returns = new int[n][n];
		final int INF = 10000 * n + 1;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(i != j) {
					map[i][j] = INF;
				}
			}	
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1; 
			map[start][end] = map[end][start] = Integer.parseInt(tokens.nextToken());
			returns[start][end] = end+1;
			returns[end][start] = start+1;
		}
		System.out.println(solution(map,returns,n));
	}

	private static String solution(int[][] map, int[][] returns, int n) {
		StringBuilder sb = new StringBuilder();
		
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						returns[i][j] = returns[i][k];
					}
				}	
			}
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(returns[i][j] == 0) {
					sb.append("- ");
				}else {
					
					sb.append(returns[i][j] + " ");
				}
			}	
			sb.append("\n");
		}
		return sb.toString();
	}

}
