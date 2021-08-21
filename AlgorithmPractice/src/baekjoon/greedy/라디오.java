package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ¶óµð¿À {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,a,b,n));
	}

	private static int solution(int[] arr, int a, int b, int n) {
		int idx = 0;
		int minDiff = Integer.MAX_VALUE;
		for(int i =0 ;i<arr.length;++i) {
			int diff = Math.abs(b - arr[i]); 
			if (minDiff > diff) { 
				minDiff = diff; 
				idx = i; 
			}
		}
		return Math.abs(a-b) < 1 + Math.abs(arr[idx] - b) ?
				Math.abs(a-b) : 1+ Math.abs(arr[idx]-b);
	}

}
