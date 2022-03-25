package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열large {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[] arr, int n, int k) {
		int answer = 0;
		int start = 0;
		int end = 0;
		int count = 0;
		while(end < n) {
			if(count < k) {
				if(arr[end++] % 2 == 1) {
					//홀수 갯수
					count++;
				}
				answer = Math.max(end - start - count, answer);
			}else if(arr[end] % 2 == 0){
				end++;
				answer = Math.max(end - start - count, answer);
			}else {
				if(arr[start++] % 2 == 1) {
					count--;
				}
			}
		}
		return answer;
	}

}
