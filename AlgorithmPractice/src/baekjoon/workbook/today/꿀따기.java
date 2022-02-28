package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 曹蝶扁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int[] sum = new int[n+1];
		for(int i=1;i<=n;++i) {
			sum[i] = sum[i-1] + arr[i-1];
		}
		//国国曹
		for(int i=1;i<n;++i) {
			answer = Math.max(answer, sum[n] - arr[0] - arr[i] + sum[n] - sum[i+1]);
		}
		//曹国国
		for(int i=1;i<n-1;++i) {
			answer = Math.max(answer, sum[n] - arr[n-1] - arr[i] + sum[i]);
		}
		//国曹国
		for(int i=1;i<n-1;++i) {
			answer = Math.max(answer, sum[i+1] - arr[0] + sum[n] - sum[i] - arr[n-1]);
		}
		
		return answer;
	}

}
