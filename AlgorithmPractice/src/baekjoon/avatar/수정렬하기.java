package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		for(int i=0;i<n;++i) {
			sb.append(arr[i] + "\n");
		}
		
		
		return sb.toString();
	}

}
