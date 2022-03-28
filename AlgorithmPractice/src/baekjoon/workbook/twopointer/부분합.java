package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ºÎºÐÇÕ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr =new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[] arr, int n, int k) {
		int answer = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		long sum = 0;
		while(end <= n) {
			if(sum >= k){
				sum -= arr[start++];
				answer = Math.min(end - start + 1, answer);
			}else if(end == n) {
				break;
			}else {
				sum += arr[end++];
			}
		}
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

}
