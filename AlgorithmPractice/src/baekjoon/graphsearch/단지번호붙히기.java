package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙히기 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visited;
	public static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<n;++j) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[][] arr, int n) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> homes = new ArrayList<>();
		visited = new boolean[n][n];
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				int data = arr[i][j];
				if(data != 0) {
					if(!visited[i][j]) {
						cnt = 1;
						visited[i][j] = true;
						dfs(arr,i,j,n,1);
						homes.add(cnt);
					}
				}
			}
		}
		Collections.sort(homes);
		sb.append(homes.size() + "\n");
		for(int data : homes) {
			sb.append(data + "\n");
		}
		
		return sb.toString();
	}

	private static void dfs(int[][] arr, int x, int y,int n,int count) {
		for(int k=0;k<4;++k) {
		   int idx = x + dx[k];
		   int jdy = y + dy[k];
		   if(0 <= idx && idx < n && 0 <= jdy && jdy < n) {
			   if(arr[idx][jdy] != 0 && !visited[idx][jdy]) {
				   visited[idx][jdy] = true;
				   cnt++;
				   dfs(arr, idx, jdy, n, count);
				   
			   }
		   }
		}
	}

}
