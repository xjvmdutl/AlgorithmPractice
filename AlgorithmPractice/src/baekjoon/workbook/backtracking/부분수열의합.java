package baekjoon.workbook.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {
	public static boolean[] visit;
	public static int answer;
	private static int solution(int[] arr, int n, int s) {
		answer = 0;
		for(int i=1;i<=n;++i) {
			visit = new boolean[n];
			int[] per = new int[i];
			backtracking(arr, per, 0, 0, i, s);
		}
		return answer;
	}
	private static void backtracking(int[] arr, int[] per, int index, int count, int length, int s) {
		if(count == length) {
			int sum = 0;
			for(int i=0;i<per.length;++i)
				sum += per[i];
			if(sum == s)
				answer++;
			return;
		}
		for(int i=index;i<arr.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				per[count] = arr[i];
				backtracking(arr, per, i, count+1, length, s);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int s = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,s));
	}

	

}
