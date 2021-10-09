package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		long[] arr = new long[n];
		for(int i=0;i<n;++i) {
			arr[i] = Long.parseLong(reader.readLine());
		}
		System.out.println(solution(arr,n,c));
	}

	private static long solution(long[] arr, int n, int c) {
		long answer = 0;
		Arrays.sort(arr);
		long start = 1;
		long end = arr[n-1] - arr[0];
		while(start <= end) {
			long mid = (start + end) / 2;
			long first = arr[0];
			
			int count = 1;
			for(int i=0;i<n;++i) {
				long d = arr[i] - first;
				if(d >= mid) {
					count++;
					first = arr[i];
				}
			}
			if(count >= c) {
				answer = mid;
				start = mid + 1;
			}else {
				end = mid-1;
			}
		}
		return answer;
	}

}
