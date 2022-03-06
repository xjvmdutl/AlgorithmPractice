package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ∆Ì¿«¡°2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static long solution(int[][] arr, int n) {
		int[] xs = new int[n];
		for(int i=0;i<n;++i)
			xs[i] = arr[i][0];
		int[] ys = new int[n];
		for(int i=0;i<n;++i)
			ys[i] = arr[i][1];
		Arrays.sort(xs);
		Arrays.sort(ys);
		int x = xs[n/2];
		int y = ys[n/2];
		long answer = 0;
		for(int i=0;i<n;++i) {
			answer += Math.abs(arr[i][0] - x);
			answer += Math.abs(arr[i][1] - y);
		}
		return answer;

	}

}
