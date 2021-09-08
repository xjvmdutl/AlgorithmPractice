package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Á¤¼ö»ï°¢Çü {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][];
		for(int i=0;i<n;++i) {
			arr[i] = new int[i+1];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<=i;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		for(int i=1;i<n;++i) {
			arr[i][0] += arr[i-1][0];
			for(int j=1;j<i;++j) {
				arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
			}
			arr[i][i] += arr[i-1][i-1];
		}
		for(int i=0;i<n;++i) {
			answer = Math.max(answer, arr[n-1][i]);
		}
		return answer;
	}

}
