package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		long m = Long.parseLong(tokens.nextToken());
		long[] arr = new long[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Long.parseLong(tokens.nextToken());
		}
		System.out.println(solution(arr,n,m));
	}

	private static long solution(long[] arr, int n, long m) {
		long answer = 0;
		long start = 0;
		long end = Arrays.stream(arr).max().getAsLong();
		while(start <= end) {
			long mid = (start + end) / 2;
			long total = 0;
			for(int i=0;i<n;++i) {
				if(arr[i] > mid) {
					total += arr[i] - mid;
				}
			}
			if(total < m) {
				end = mid - 1;
			}else {
				start = mid + 1;
				answer = mid;
			}
		}
		return answer;
	}

}
