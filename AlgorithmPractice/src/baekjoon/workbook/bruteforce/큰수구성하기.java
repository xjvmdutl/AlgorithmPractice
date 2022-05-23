package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 큰수구성하기 {
	private static int answer;
	private static int solution(int[] arr, int n, int k) {
		Set<Integer> contains = new HashSet<>();
		for(int num : arr) {
			contains.add(num);
		}
		int max = Collections.max(contains);
		int length = String.valueOf(n).length();
		answer = 0;
		for(int i=1;i<length;++i) {
			answer *= 10;
			answer += max;
		}
		permutation(arr, 0, length, new StringBuilder(), n);
		return answer;
	}

	private static void permutation(int[] arr, int size, int length, StringBuilder sb, int n) {
		if(size == length) {
			int number = Integer.parseInt(sb.toString());
			if(number <= n) {
				answer = Math.max(answer, number);
			}
			return;
		}
		
		for(int i=0;i<arr.length;++i) {
			sb.append(arr[i]);
			permutation(arr, size+1, length, sb, n);
			sb.delete(sb.length()-1, sb.length());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[k];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<k;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, k));
	}

}
