package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Àú¿ï {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i =0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			arr[a][b] = 1;
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[][] arr, int n) {
		final int INF = 2000*100 + 1;
		int[][] d = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(arr[i][j] == 0 && i != j)
					d[i][j] = INF;
				else
					d[i][j] = arr[i][j];
			}	
		}
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}	
			}	
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;++i) {
			int count = 0;
			for(int j=0;j<n;++j) {
				if(d[i][j] == INF && d[j][i] == INF) {
					count++;
				}
			}
			sb.append(count + "\n");
		}	
		return sb.toString();
	}
}
