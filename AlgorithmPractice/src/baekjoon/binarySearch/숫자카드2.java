package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] arr = new long[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Long.parseLong(tokens.nextToken());
		}
		int m = Integer.parseInt(reader.readLine());
		long[] search = new long[m];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<m;++i) {
			search[i] = Long.parseLong(tokens.nextToken());
		}
		
		System.out.println(solution(arr,n,search));
	}

	private static String solution(long[] arr, int n, long[] search) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		for(int i=0;i<search.length;++i) {
			int idx = Arrays.binarySearch(arr, search[i]);
			int count = 0;
			if(idx >= 0) {
				count = upper_bound(arr,search[i])-lower_bound(arr,search[i]);
			}
			sb.append(count + " ");
		}
		
		
		return sb.toString();
	}

	private static int upper_bound(long[] arr, long num) {
		int start = 0;
		int end = arr.length;
		while(start<end) {
			int mid = (start +end) /2;
			if(num < arr[mid]) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return end;
	}

	private static int lower_bound(long[] arr, long num) {
		int start = 0;
		int end = arr.length;
		while(start<end) {
			int mid = (start +end) /2;
			if(num <= arr[mid]) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}

}
