package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Επ»η {
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

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		int[] number = new int[n+1];
		
		for(int i=0;i<arr.length;++i) {
			int now = i + arr[i][0];
			int money = number[i] + arr[i][1];
			if(now > n)
				continue;
			for(int j=now;j<=n;++j) {
				number[j] = Math.max(number[j], money);
			}
		}
		for(int i=0;i<=n;++i) {
			answer = Math.max(answer, number[i]);
		}
		return answer;
	}
}
