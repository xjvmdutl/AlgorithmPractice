package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DFS¿ÍBFS {
	public static boolean[] visited;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		int v = Integer.parseInt(strs[2]);
		int[][] arr = new int[n][n];
		for(int i=0;i<m;++i){
			strs = reader.readLine().split(" ");
			int idx = Integer.parseInt(strs[0])-1;
			int jdx = Integer.parseInt(strs[1])-1;
			arr[idx][jdx] = 1;
			arr[jdx][idx] = 1;
		}
		System.out.println(solution(arr,n,v,"dfs"));
		System.out.println(solution(arr,n,v,"bfs"));
	}
	
	private static String solution(int[][] arr, int n, int v,String str) {
		
		visited = new boolean[n];
		sb = new StringBuilder();
		visited[v-1] = true;
		int now = v-1;
		if(str.equals("dfs")) {
			//dfs
			dfs(arr,now);
		}else if(str.equals("bfs")) {
			//bfs
			bfs(arr,now);
		}
		return sb.delete(sb.length()-1, sb.length()).toString();
	}


	private static void bfs(int[][] arr, int now) {
		
		Queue<Integer> que = new LinkedList<>();
		sb.append((now+1) + " ");
		que.offer(now);
		while(!que.isEmpty()) {
			now = que.poll();
			
			for(int i=0;i<arr[now].length;++i) {
				int node = arr[now][i];
				if(node != 0 && !visited[i]) {
					visited[i] = true;
					que.offer(i); 
					sb.append((i+1) + " ");
				}
			}
		}
	}

	

	private static void dfs(int[][] arr ,int now) {
		sb.append((now+1) + " ");
		
		for(int i=0;i<arr[now].length;++i) {
			int node = arr[now][i];
			if(node != 0 && !visited[i]) {
				visited[i] = true;
				dfs(arr,i);
			}
		}
		
	}

}
