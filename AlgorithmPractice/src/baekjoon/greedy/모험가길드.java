package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모험가길드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr= new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, int[] arr) {
		int answer = 0;
		int count = 0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;++i) {
			count++;
			if(count >= arr[i]) {
				answer++;
				count = 0;
			}
		}
		return answer;
	}

}
