package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class µÎ¿ë¾× {

	public static void main(String[] args) throws IOException {
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
		
	}

	private static String solution(int[] arr, int n) {
		Arrays.sort(arr);
		int start = 0;
		int end = n-1;
		int min = Integer.MAX_VALUE;
		int n1 = arr[0];
		int n2 = arr[n-1];
		while(start < end) {
			if(min > Math.abs(arr[end] + arr[start])) {
				min = Math.abs(arr[end] + arr[start]);
				n1 = arr[start];
				n2 = arr[end];
			}
			if(arr[start] < 0) {
				if(Math.abs(arr[start]) < arr[end]) {
					end--;
				}else {
					start++;
				}
			}else if(arr[end] < 0){
				start++;
			}else {
				end--;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(n1 + " " + n2);
		return sb.toString();
	}

}
