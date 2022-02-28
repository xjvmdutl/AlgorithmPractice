package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ²ÞÆ²²ÞÆ²È£¼®¾Ö¹ú·¹±â´É¼º {
	public static int answer;
	public static int[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[] arr, int n, int k) {
		answer = 0;
		v = new int[n];
		dfs(arr, 0 ,0, 0, n, k);
		return answer;
	}

	private static void dfs(int[] arr, int count, int sum, int prev, int length, int k) {
		if(length == count) {
			answer = Math.max(answer, sum);
			return;
		}
		v[count] = 1;
		prev += arr[count];
		if(prev >= k)
			dfs(arr, count+1, sum + (prev - k), 0, length, k);
		else 
			dfs(arr, count+1, sum , prev, length, k);
		v[count] = 0;
		dfs(arr, count+1, sum , 0, length, k);
	}

}
