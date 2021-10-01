package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Å°¼ø¼­ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][n];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			arr[a][b] = 1;
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		final int INF = 501;
		int[][] d = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(i != j && arr[i][j] == 0) {
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
		int answer = 0;
		for(int i=0;i<n;++i) {
			boolean flag = true;
			for(int j=0;j<n;++j) {
				if(d[i][j] == INF &&  d[j][i] == INF ) {
					flag = false;
					break;
				}
			}
			if(flag) {
				answer++;
			}
		}
		return answer;
	}

}
