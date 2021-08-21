package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ÃÌ¼ö°è»ê {
	public static boolean[] visit;
	public static Queue<Integer> que;
	public static int[] depth;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int start = Integer.parseInt(tokens.nextToken()) - 1;
		int end = Integer.parseInt(tokens.nextToken()) - 1;
		int m = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int j = Integer.parseInt(tokens.nextToken())-1;
			int k = Integer.parseInt(tokens.nextToken())-1;
			arr[j][k] = 1;
			arr[k][j] = 1;
		}
		System.out.println(solution(arr,start,end,n));
	}

	private static int solution(int[][] arr, int start, int end,int n) {
		int answer = 0;
		visit = new boolean[n];
		que = new LinkedList<>();
		visit[start] = true;
		depth = new int[n];
		depth[start] = 1;
		que.offer(start);
		bfs(arr,n,end);
		if(depth[end] == 0)
			answer = -1;
		else
			answer = depth[end]-1;
		return answer;
	}

	private static void bfs(int[][] arr, int n, int end) {
		
		while(!que.isEmpty()) {
			int nData = que.poll();
			
			for(int i=0;i<n;++i) {
				if(!visit[i] && arr[nData][i] == 1) {
					visit[i] = true;
					que.offer(i);
					depth[i] = depth[nData]+1;
				}
			}
		}
		
	}
}
