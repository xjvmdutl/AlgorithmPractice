package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서강그라운드 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int[][] arr= new int[n][n];
		int[] nodes = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			nodes[i] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=0;i<r;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			int l = Integer.parseInt(tokens.nextToken());
			arr[start][end] = l;
			arr[end][start] = l;
		}
		System.out.println(solution(arr,nodes,m,n));
	}

	private static int solution(int[][] arr, int[] nodes, int m, int n) {
		int answer = 0;
		final int INF = 15*n + 1;
		int[][] d = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(arr[i][j] == 0 && i != j) {
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
						d[i][j] =d[i][k] + d[k][j]; 
					}
				}
			}
		}
		for(int i=0;i<n;++i) {
			int sum = 0;
			for(int j=0;j<n;++j) {
				if(d[i][j] > m) {
					continue;
				}
				sum += nodes[j];
			}
			answer = Math.max(answer, sum);
		}
		return answer;
	}

}
