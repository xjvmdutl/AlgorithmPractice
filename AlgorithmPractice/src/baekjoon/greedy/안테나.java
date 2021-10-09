package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ¾ÈÅ×³ª {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		Arrays.sort(arr);
		int answer  = 0;
		if(arr.length % 2 == 0) {
			answer = arr[arr.length/2 - 1];
		}else {
			answer = arr[arr.length/2];
		}
		return answer;
	}

}
