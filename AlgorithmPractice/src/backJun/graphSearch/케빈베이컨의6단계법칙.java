package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {
	public static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][n];
		
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int n1 = Integer.parseInt(tokens.nextToken())-1;
			int n2 = Integer.parseInt(tokens.nextToken())-1;
			arr[n1][n2] = 1;
			arr[n2][n1] = 1;
		}
		
		System.out.println(solution(arr,n,m));
	}

	private static int solution(int[][] arr, int n, int m) {
		int answer = Integer.MAX_VALUE;
		int idx=0;
		for(int i=0;i<n;++i) {
			visited = new int[n];
			bfs(arr,i);
			int sum = 0;
			for(int j=0;j<n;++j) {
				sum += visited[j]-1;
			}
			if(answer > sum ) {
				idx = i;
				answer = sum;
			}
		}
		return idx+1;
	}

	private static void bfs(int[][] arr, int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		visited[start] = 1; 
		while(!que.isEmpty()) {
			int data = que.poll();
			for(int i=0;i<arr[data].length;++i) {
				if(visited[i] == 0 && arr[data][i] == 1) {
					visited[i] = visited[data] + 1;
					que.offer(i);
				}
			}
		}
	}

}
