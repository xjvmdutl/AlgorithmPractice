package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0인네정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][4];
		for(int i = 0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<4;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n));
	}

	private static long solution(int[][] arr, int n) {
		long answer = 0;
		int[] AB = new int[n * n];
		int[] CD = new int[n * n];
		int idx = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				AB[idx] = arr[i][0] + arr[j][1];
				CD[idx] = arr[i][2] + arr[j][3];
				idx ++;
			}
		}
		Arrays.sort(CD);
		for(int result : AB) {
			int left = upperBound(CD , -result);
			int right = lowerBound(CD , -result);
			answer += left - right;
		}
		
		return answer;
	}

	private static int upperBound(int[] CD, int find) {
		int left = 0;
	    int right = CD.length - 1;
	    while (left <= right) {
	      int mid = (left + right) / 2;
	      if (CD[mid] <= find) {
	        left = mid + 1;
	      } else {
	        right = mid - 1;
	      }
	    }
	    return left;
	}

	private static int lowerBound(int[] CD, int find) {
		int left = 0;
		int right = CD.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(CD[mid] < find) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}

}
