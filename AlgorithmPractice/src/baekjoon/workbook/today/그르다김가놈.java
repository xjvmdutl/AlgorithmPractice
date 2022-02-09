package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ±×¸£´Ù±è°¡³ð {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		long[] arr = new long[n];
		for(int i=0;i<n;++i)
			arr[i] = Long.parseLong(reader.readLine());
		System.out.println(solution(arr, n, m, k));
	}

	private static long solution(long[] arr, int n, int m, int k) {
		long answer = 0;
		
		for(int i=0;i < arr.length; ++i) {
			if(arr[i] <= k) {
				arr[i] = 0;
			}else if(arr[i] < 2*k) {
				arr[i] -= k;
			}else {
				arr[i] -= 2* k;
			}
		}
		long start = 1;
		long end = 1000000000;
		while(start <= end) {
			long mid = (start + end) / 2;
			long mSum = 0;
			for(int i=0;i < arr.length; ++i) {
				long p = arr[i]/mid;
				mSum += p;
			}
			if(mSum >= m) {
				start = mid+1;
				answer = Math.max(mid, answer);
			}else {
				end = mid - 1;
			}
			
		}
		return answer == 0 ? -1 : answer;
	}
}
