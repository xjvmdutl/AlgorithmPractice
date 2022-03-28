package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class гуюл0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static long solution(int[] arr, int n) {
		long answer = 0;
		Arrays.sort(arr);
		for(int i=0;i<n;++i) {
			if(arr[i] > 0) {
				break;
			}
			int start = i + 1;
			int end = n - 1;
			while(start < end) {
				int sCount = 1;
				int eCount = 1;
				int sum = arr[i] + arr[start] + arr[end];
				if(sum == 0) {
					if(arr[start] == arr[end]) {
						answer += combine(end - start + 1);
						break;
					}
					while(start + 1 < end && arr[start] == arr[start+1]) {
						sCount++;
						start++;
					}
					while(start < end - 1 && arr[end] == arr[end-1]) {
						eCount++;
						end--;
					}
					answer += sCount * eCount;
				}
				if(sum > 0) {
					end--;
				}else {
					start++;
				}
			}
		}
		return answer;
	}

	private static long combine(int num) {
		return num * (num - 1) / 2;
	}

}
