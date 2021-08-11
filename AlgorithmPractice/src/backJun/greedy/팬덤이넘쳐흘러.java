package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ÆÒ´ıÀÌ³ÑÃÄÈê·¯ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		
		int time = 0;
		int start = arr[0][0];
		int end = arr[0][1];
		for(int i=1;i<arr.length;++i) {
			if(arr[i][1] < start) {
				time += start - arr[i][1];
				start = arr[i][0];
			}else {
				if(arr[i][0] > end) {
					time += arr[i][0] - end;
					end = arr[i][1];
				}
			}
		}
		return time;
	}

}
