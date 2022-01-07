package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
	public static int[] arr;
	public static boolean[] visit;
	
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,m));
	}

	private static String solution(int n, int m) {
		arr = new int[m];
		visit = new boolean[n];
		sb = new StringBuilder();
		permulate(1,n,0,m);
		return sb.toString();
	}

	private static void permulate(int count, int n, int index, int m) {
		if(index == m) { // 뽑은 갯수가 M 일경우
			for(int number : arr) //arr에 모든경우의 수가 있다
				sb.append(number + " ");
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;++i) {
			if(!visit[i-1]) {
				visit[i-1] = true;
				arr[index] = i;
				permulate(count+1, n, index+1, m);
				visit[i-1] = false;
			}
		}
	}

}
