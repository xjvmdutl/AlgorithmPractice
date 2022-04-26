package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원상복구small {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] s = new int[n];
		int[] d = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			s[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			d[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(s, d, n, k));
	}

	private static String solution(int[] s, int[] d, int n, int k) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<k;++i) {
			s = mix(s, d, n);
		}
		print(answer, s);
		return answer.toString();
	}

	private static int[] mix(int[] s, int[] d, int n) {
		int[] result = new int[n];
		for(int i=0;i<d.length;++i) {
			result[d[i] - 1] = s[i];
		}
		return result;
	}
	
	private static void print(StringBuilder answer, int[] p) {
		for(int i=0;i<p.length;++i) {
			answer.append(p[i] + " ");
		}
	}

}
