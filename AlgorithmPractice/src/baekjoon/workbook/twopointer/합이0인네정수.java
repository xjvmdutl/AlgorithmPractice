package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.StringTokenizer;

public class 합이0인네정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][4];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			arr[i][2] = Integer.parseInt(tokens.nextToken());
			arr[i][3] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static long solution(int[][] arr, int n) {
		long answer = 0;
		int[] AB = new int[n*n];
		int[] CD = new int[n*n];
		int index = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				AB[index] = arr[i][0] + arr[j][1];
				CD[index++] = arr[i][2] + arr[j][3];
			}	
		}
		Arrays.sort(CD);
		
		return answer;
	}

}
