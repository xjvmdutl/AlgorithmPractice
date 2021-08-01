package backJun.stepBystep.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바이러스 {
	public static boolean[] visited;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<m;++i) {
			String[] str = reader.readLine().split(" ");
			int idx = Integer.parseInt(str[0]) - 1;
			int jdx = Integer.parseInt(str[1]) - 1;
			arr[idx][jdx] = 1;
			arr[jdx][idx] = 1;			
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		answer = 0;
		visited = new boolean[n];
		visited[0] = true;
		dfs(arr,0);
		return answer;
	}

	private static void dfs(int[][] arr,int target) {
		for(int i=0;i<arr[target].length;++i) {
			if(arr[target][i] != 0 && !visited[i]) {
				visited[i] = true;
				answer++;
				dfs(arr,i);
			}
		}
	}

}
