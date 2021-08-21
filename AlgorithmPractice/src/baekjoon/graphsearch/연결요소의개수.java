package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 연결요소의개수 {
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][n];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(tokens.nextToken()) - 1;
			int v = Integer.parseInt(tokens.nextToken()) - 1;
			arr[u][v] = 1;
			arr[v][u] = 1;
		}
		
		System.out.println(solution(arr,n,m));
	
	}

	private static int solution(int[][] arr, int n, int m) {
		int answer = 0;
		visited = new boolean[n];
		for(int i=0;i<n;++i) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(arr,i);
				answer++;
			}
		}
		
		return answer;
	}

	private static void dfs(int[][] arr, int idx) {
		for(int i=0;i<arr[idx].length;++i) {
			if(!visited[i] && arr[idx][i] == 1) {
				visited[i] = true;
				dfs(arr,i);
			}
		}
	}

}
