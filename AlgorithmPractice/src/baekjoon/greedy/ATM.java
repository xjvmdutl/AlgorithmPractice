package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] p = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i = 0 ;i<n;++i)
			p[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,p));
	}

	private static int solution(int n, int[] p) {
		int answer = 0;
		Arrays.sort(p);
		int sum = 0;
		for(int i=0;i<n;++i) {
			sum += p[i];
			answer += sum;
		}
		return answer;
	}

	
	
}
