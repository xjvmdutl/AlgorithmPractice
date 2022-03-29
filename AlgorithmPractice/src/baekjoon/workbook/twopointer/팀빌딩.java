package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ÆÀºôµù {

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

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int start = 0;
		int end = n-1;
		while(start < end) {
			answer = Math.max(answer, (end - start - 1) * Math.min(arr[start], arr[end]));
			if(arr[start] < arr[end]) {
				start++;
			}else {
				end--;
			}
			
		}
		
		return answer;
	}
}
