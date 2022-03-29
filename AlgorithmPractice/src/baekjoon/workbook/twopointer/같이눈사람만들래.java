package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 같이눈사람만들래 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static long solution(int[] arr, int n) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(arr);
		boolean[] visit = new boolean[n];
		for(int i=0;i<n;++i) {
			for(int j=i+1;j<n;++j) {
				long now = arr[i] + arr[j];
				visit[i] = true;
				visit[j] = true;
				int start = 0;
				int end = n - 1;
				while(start < end) {
					if(visit[start]) {
						start++;
						continue;
					}
					if(visit[end]) {
						end--;
						continue;
					}
					long snow1 = arr[i] + arr[j];
					long snow2 = arr[start] + arr[end];
					answer = Math.min(Math.abs(snow1 - snow2), answer);
					if(snow1 < snow2) {
						end--;
					}else if(snow1 > snow2) {
						start++;
					}else {
						return 0;
					}
				}
				visit[i] = false;
				visit[j] = false;
			}
		}
		return answer;
	}

}
