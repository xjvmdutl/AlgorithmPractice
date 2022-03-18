package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장가까운공통조상 {
	public static int[] parents;
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			parents = new int[n];
			Arrays.fill(parents, -1);
			for(int i=0;i<n-1;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken()) - 1;
				int end = Integer.parseInt(tokens.nextToken()) - 1;
				parents[end] = start;
			}
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken()) - 1;
			int b = Integer.parseInt(tokens.nextToken()) - 1;
			System.out.println(solution(n, a, b));
		}
	}
	private static int solution(int n, int a, int b) {
		visit = new boolean[n];
		find(a);
		int index = findIndex(b);
		return index + 1;
	}
	private static int findIndex(int b) {
		if(visit[b]) {
			return b;
		}
		return findIndex(parents[b]);
	}
	private static void find(int a) {
		visit[a] = true;
		if(parents[a] != -1) {
			find(parents[a]);
		}
	}

}
