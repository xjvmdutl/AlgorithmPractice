package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 두수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
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
	}

	private static int solution(int[] arr, int n, int k) {
		int start = 0;
		int answer  = 0;
		int end = n - 1;
		Arrays.sort(arr);
		int best = Integer.MAX_VALUE;
		while(start < end) {
			int sum = arr[start] + arr[end];
			if(Math.abs(sum - k) == best) {
				answer++;
			}else if(Math.abs(sum - k) < best) {
				answer = 1;
				best = Math.abs(sum - k);
			}
			if(sum == k) {
				start++;
				end--;
			}else if(sum < k) {
				start++;
			}else{
				end--;
			}
			
		}
		return answer;
	}

}
