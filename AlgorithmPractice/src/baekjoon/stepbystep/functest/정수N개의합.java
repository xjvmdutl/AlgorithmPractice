package baekjoon.stepbystep.functest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수N개의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr));
	}

	private static long solution(int[] arr) {
		int answer = 0;
		for(int i=0;i<arr.length;++i) {
			answer += arr[i];
		}
		return answer;
	}

}
