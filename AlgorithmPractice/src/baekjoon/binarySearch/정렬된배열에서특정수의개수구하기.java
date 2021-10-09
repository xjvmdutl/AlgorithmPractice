package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정렬된배열에서특정수의개수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,x));
	}

	private static int solution(int[] arr, int x) {
		int answer = 0;
		int index = Arrays.binarySearch(arr, x);
		if(index >= 0) {
			index--;
			while(index < arr.length) {
				if(arr[index] != x) {
					break;
				}
				answer++;
				index++;
			}
		}else {
			answer = -1;
		}
		return answer;
	}
}
