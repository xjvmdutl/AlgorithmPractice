package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 좋은구간 {
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(reader.readLine());
		int[] arr = new int[l];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<l;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr, l, n));
	}

	private static int solution(int[] arr, int l, int n) {
		answer = 0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;++i) {
			if(i == 0) {
				int end = arr[i]-1;
				if(1 <= n &&  n <= end) {
					counting(arr, 1, end, n);
					break;
				}
			}else {
				int start = arr[i-1] + 1;
				int end = arr[i]-1;
				if(start <= n &&  n <= end) {
					counting(arr, start, end, n);
					break;
				}
			}
		}
		return answer;
	}
	private static void counting(int[] arr, int start, int end, int n) {
		for(int j=start;j<=end;++j) {
			for(int k=j+1;k<=end;++k) {
				if(j <= n && n <= k) {
					answer++;
				}
			}	
		}
	}
}
