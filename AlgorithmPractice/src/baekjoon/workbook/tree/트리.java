package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Æ®¸® {
	public static int answer;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		int root = -1;
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			if(arr[i] == -1)
				root = i;
		}
		int remove = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr, n, remove, root));
	}

	private static int solution(int[] arr, int n, int remove, int root) {
		arr[remove] = -1;
		visit = new boolean[n];
		answer = 0;
		if(remove == root)
			return answer;
		visit[root] = true;
		dfs(arr, n, root);
		return answer;
	}

	private static void dfs(int[] arr, int n, int root) {
		boolean isLeef = true;
		for(int i=0;i<n;++i) {
			if(!visit[i] && arr[i] == root) {
				isLeef = false;
				visit[i] = true;
				dfs(arr, n, i);
			}
		}
		if(isLeef) {
			answer++;
		}
	}

}
