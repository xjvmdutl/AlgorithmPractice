package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[][] arr = new char[n][n];
		for(int i=0;i<n;++i) {
			arr[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(char[][] arr, int n) {
		int answer = n*n;
		for(int bit=0;bit<(1<<n);++bit) {
			int sum = 0;
			for(int i=0;i<n;++i) {
				int tail = 0;
				for(int j=0;j<n;++j) {
					char cur = arr[j][i];
					if((bit&(1<<j)) != 0) {
						cur = change(cur);
					}
					if(cur == 'T')
						tail++;
				}
				sum += Math.min(tail, n - tail);
			}
			if(sum < answer)
				answer = sum;
		}
		return answer;
	}

	private static char change(char cur) {
		if(cur == 'H')
			return 'T';
		else
			return 'H';
	}

}
