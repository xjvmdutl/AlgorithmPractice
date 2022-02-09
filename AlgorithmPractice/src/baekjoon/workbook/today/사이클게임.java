package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사이클게임 {
	public static boolean[] visit;
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[m][2];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, m));
	}

	private static int solution(int[][] arr, int n, int m) {
		int answer = 0;
		parent = new int[n];
		for(int i=0;i<n;++i)
			parent[i] = i;
		visit = new boolean[n];
		for(int i=0;i<m;++i) {
			int a = find(arr[i][0]);
			int b = find(arr[i][1]);
			if(union(a,b)) {
				return i+1;
			}
		}
		
		return answer;
	}

	private static boolean union(int a, int b) {
		if(a == b)
			return true;
		parent[b] = a;
		return false;
	}

	private static int find(int node) {
		if(node == parent[node])
			return node;
		return parent[node] = find(parent[node]);
	}

}
