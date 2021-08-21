package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 등수매기기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr= new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(n,arr));
	}

	private static long solution(int n, int[] arr) {
		long answer = 0;
		Arrays.sort(arr);
		for(int i=1;i<=arr.length;++i) {
			answer += Math.abs(i-arr[i-1]);
		}
		return answer;
	}

}
