package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(reader.readLine());
		int b = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr,n,b,c));
	}

	private static long solution(int[] arr, int n, int b, int c) {
		long answer = 0;
		for(int i=0;i<n;++i) {
			answer++;
			int num = arr[i] - b;
			if(num >0) {
				if(num % c == 0)
					answer += num/c;
				else
					answer += (num/c) + 1;
			}
		}
		return answer;
	}

}
