package baekjoon.workbook.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 서강그라운드 {
	static class Node implements Comparable<Node>{
		int now;
		int dis;
		public Node(int now, int dis) {
			this.dis = dis;
			this.now = now;
		}
		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}
	private static final int INF = (100 * 30) + 1;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		int[][] map = getMap(n);
		for(int i=0;i<r;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			int dis = Integer.parseInt(tokens.nextToken());
			map[start][end] = dis;
			map[end][start] = dis;
		}
		System.out.println(solution(map, arr, n, m, r));
	}

	private static int[][] getMap(int n) {
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(i == j) {
					map[i][j] = 0;
				}else {
					map[i][j] = INF;
				}
			}	
		}
		return map;
	}
	
	private static int solution(int[][] map, int[] arr, int n, int m, int r) {
		floydWhashal(map, n);
		return getResult(map, arr, n, m);
	}

	private static void floydWhashal(int[][] map, int n) {
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}	
			}	
		}
	}
	
	private static int getResult(int[][] map, int[] arr, int n, int m) {
		int answer = 0;
		for(int i=0;i<n;++i) {
			int sum = 0;
			for(int j=0;j<n;++j) {
				if(map[i][j] <= m) {
					sum += arr[j];
				}
			}	
			answer = Math.max(answer, sum);
		}	
		return answer;
	}

}
