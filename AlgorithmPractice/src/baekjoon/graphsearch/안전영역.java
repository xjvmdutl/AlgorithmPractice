package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역 {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		int max = 0;
		for(int i = 0;i<n; ++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		System.out.println(solution(arr,n,max));
	}

	private static int solution(int[][] arr, int n, int max) {
		int answer = 0;
		for(int k=0;k<=max;++k) {
			visit = new boolean[n][n];
			int count = 0;
			for(int i=0;i<arr.length;++i) {
				for(int j=0;j<arr[i].length;++j) {
					if(!visit[i][j] && arr[i][j] > k) {
						count++;
						visit[i][j] = true;
						dfs(arr,k,n,j,i);
					}
				}
			}
			answer = Math.max(answer, count);
		}
		return answer;
	}

	private static void dfs(int[][] arr, int k, int n, int x, int y) {
		for(int i=0;i<4;++i) {
			int idx =  x + dx[i];
			int jdx =  y + dy[i];
			if(0 <= idx && idx < n && 0 <= jdx && jdx < n) {
				if(!visit[jdx][idx] && arr[jdx][idx] > k) {
					visit[jdx][idx] = true;
					dfs(arr, k, n, idx, jdx);
				}
			}
		}
	}

}
