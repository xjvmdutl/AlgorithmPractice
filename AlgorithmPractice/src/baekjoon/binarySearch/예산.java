package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ¿¹»ê {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		long m = Long.parseLong(reader.readLine());
		System.out.println(solution(arr,n,m));
	}

	private static long solution(int[] arr, int n, long m) {
		int answer = 0;
		int start = 1;
		int end = Arrays.stream(arr).max().getAsInt();
		while(start <= end) {
			int mid = (start + end) / 2;
			long sum = 0;
			for(int i=0;i<arr.length;++i) {
				int now = arr[i];
				if(now > mid) {
					now = mid;
				}
				sum += now;
			}
			if(sum <= m) {
				start = mid + 1;
				answer = mid;
			}else {
				end = mid - 1;
			}
		}
		return answer;
	}

}
