package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {
	private static final int INF = 10000000;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][n];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken())-1;
			int e = Integer.parseInt(tokens.nextToken())-1;
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = Integer.MAX_VALUE;
		int[][] d = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(i == j) {
					d[i][j] = 0;
				}else if(arr[i][j] == 0) {
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
		int minIdx = 0;
		for(int i=0;i<n;++i) {
			int sum = 0;
			for(int j=0;j<n;++j) {
				sum += d[i][j];
			}
			if(answer > sum) {
				answer = sum;
				minIdx = (i+1);
			}
		}
		return minIdx;
	}

}
