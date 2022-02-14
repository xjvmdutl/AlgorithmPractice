package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {

	public static void main(String[] args) throws IOException {
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
		int[] dpLeft = new int[n];
		int[] dpRight = new int[n];
		for(int i=0;i<n;++i) {
			dpLeft[i] = 1;
			for(int j=0;j<i;++j) {
				if(arr[i] > arr[j]) {
					dpLeft[i] = Math.max(dpLeft[j]+1, dpLeft[i]);
				}
			}
		}
		for(int i=n-1;i>=0;--i) {
			dpRight[i] = 1;
			for(int j=n-1;j>i;--j) {
				if(arr[i] > arr[j]) {
					dpRight[i] = Math.max(dpRight[j]+1, dpRight[i]);
				}
			}
		}
		for(int i=0;i<n;++i) {
			answer = Math.max(answer, dpLeft[i] + dpRight[i]);
		}
		return answer -1;
	}

}
