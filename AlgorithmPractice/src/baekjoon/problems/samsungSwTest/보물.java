package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class º¸¹° {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] a = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i)
			a[i] = Integer.parseInt(tokens.nextToken());
		int[] b = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i)
			b[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(a,b,n));
		
	}

	private static int solution(int[] a, int[] b, int n) {
		int answer = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		for(int i=0;i<n;++i) {
			answer += a[i] * b[n-i-1];
		}
		
		
		return answer;
	}

}
