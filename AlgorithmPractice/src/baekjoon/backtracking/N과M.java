package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N°úM {
	public static int[] arr;
	public static StringBuilder sb;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,m));
	}

	private static String solution(int n, int m) {
		arr = new int[m];
		sb = new StringBuilder();
		visit = new boolean[n];
		dfs(1,n,0,m);
		return sb.toString();
	}

	private static void dfs(int count, int n, int index, int m) {
		if(index == m) {
			for(int number : arr)
				sb.append(number + " ");
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;++i) {
			if(!visit[i-1]) {
				visit[i-1] = true;
				arr[index] = i;
				dfs(count+1, n, index+1, m);
				visit[i-1] = false;
			}
		}
	}

}
