package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		long[] arr = new long[k];
		for(int i=0;i<k;++i) {
			arr[i] = Long.parseLong(reader.readLine());
		}
		System.out.println(solution(arr,n,k));
	}

	private static long solution(long[] arr, int n, int k) {
		long start = 1;
		long end = Arrays.stream(arr).max().getAsLong();
		long answer = 0;
		while(start <= end) {
			long mid = (start + end) / 2;
			int count = 0;
			for(int i=0;i<arr.length;++i) {
				count += arr[i]/mid;
			}
			if(count < n) {
				end = mid-1;
			}else {
				start = mid +1;
				answer = Math.max(answer, mid);
			}
		} 
		return answer;
	}

}
