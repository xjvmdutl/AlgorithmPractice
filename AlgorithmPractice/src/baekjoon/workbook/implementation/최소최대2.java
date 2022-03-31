package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소최대2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int[] arr = new int[n];
			for(int i=0;i<n;++i) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(arr, n));
		}
	}

	private static String solution(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();
		sb.append(min + " " + max);
		return sb.toString();
	}

}
