package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ¿Õº¹ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		long k = Long.parseLong(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[] arr, int n, long k) {
		long sum = Arrays.stream(arr).sum();
		if(k >= sum) {
			k-= sum;
			for(int i=n-1;i>=0;--i) {
				k -= arr[i];
				if(k < 0) {
					return i+1;
				}
			}
		}else {
			for(int i=0;i<n;++i) {
				k -= arr[i];
				if(k < 0) {
					return i+1;
				}
			}
		}
		
		return -1;
	}

}
