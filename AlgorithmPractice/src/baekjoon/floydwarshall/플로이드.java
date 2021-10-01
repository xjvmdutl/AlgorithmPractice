package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken());
			if(arr[a][b] == 0) {
				arr[a][b] = c;
			}else if(arr[a][b] > c) {
				arr[a][b] = c;
			}
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[][] arr, int n) {
		StringBuilder sb = new StringBuilder();
		final int INF = 100001*n;
		int[][] d = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(arr[i][j] == 0 && i!=j) {
					d[i][j] = INF;
				}else {
					d[i][j] = arr[i][j];
				}
			}
		}
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(d[i][j] == INF)
					d[i][j] = 0;
				sb.append(d[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
