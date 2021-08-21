package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 행복유치원 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int k = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(arr,n,k));
	}

	private static int solution(int[] arr, int n, int k) {
		int answer = 0;
		Arrays.sort(arr);
		int[] diff = new int[n-1];
		for(int i= 1;i<arr.length;++i) {
			diff[i-1] = arr[i] - arr[i-1];
		}
		Arrays.sort(diff);
		for(int i=0;i<n-k;++i) {
			answer += diff[i];
		}
		return answer;
	}

}
