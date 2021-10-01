package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¿ª»ç {
	public static int[][] d;
	public static final int INF = 400 * 50000 +1;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][n];
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			arr[a][b] = 1;
		}
		solution(arr,n);
		int s = Integer.parseInt(reader.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			
			int answer = 0;
			if (d[start][end] == INF && d[end][start] == INF) {
				answer = 0;
			}else if(d[start][end] > d[end][start]) {
				answer = 1;
			}else {
				answer = -1;
			}
			
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void solution(int[][] arr, int n) {
	
		
		d = new int[n][n];
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
					if(d[i][j] > d[i][k] + d[k][j] )
						d[i][j] = d[i][k] + d[k][j];
				}	
			}
		}
	}

}
