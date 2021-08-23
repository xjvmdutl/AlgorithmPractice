package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class µ¢Ä¡ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[][] arr, int n) {
		int[] result = new int[n];
		
		for(int i=0;i<n;++i) {
			int rank = 1;
			for(int j=0;j<n;++j) {
				if(i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			result[i] = rank;
		}
		StringBuilder sb= new StringBuilder();
		for(int i : result) {
			sb.append(i + " ");
		}
		return sb.toString();
	}

}
