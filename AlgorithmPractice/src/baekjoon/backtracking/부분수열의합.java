package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {
	public static int answer;
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

	private static int solution(int[] arr, int n, int s) {
		answer = 0;
		for(int i=1;i<=n;++i) {
			int[] per = new int[i];
			permulation(arr,0,0,i,s,per);
		}
		return answer;
	}

	private static void permulation(int[] arr, int count, int index, int length, int s, int[] per) {
		if(count == length) {
			int sum = 0;
			for(int number : per)
				sum += number;
			if(s == sum)
				answer++;
			return;
		}
		for(int i=index;i<arr.length;++i) {
			per[count] = arr[i];
			permulation(arr, count+1, i+1, length, s, per);
		}
	}

}
