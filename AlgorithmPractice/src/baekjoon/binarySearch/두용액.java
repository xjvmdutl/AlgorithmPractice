package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class µÎ¿ë¾× {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] arr = new long[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Long.parseLong(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(long[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		int start = 0;
		int end = n-1;
		long r1 = start;
		long r2 = end;
		int max = 2000000000;
		while(start < end) {
			long sum = arr[start] + arr[end];
			if(Math.abs(sum) < max) {
				r1 = arr[start];
				r2 = arr[end];
				max = (int) Math.abs(sum);
			}
			if(sum > 0)
				end--;
			else
				start++;
		}
		sb.append(r1 + " " + r2);
		return sb.toString();
	}

}
