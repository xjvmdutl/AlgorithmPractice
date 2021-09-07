package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB°Å¸® {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][3];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] =Integer.parseInt(tokens.nextToken());
			arr[i][1] =Integer.parseInt(tokens.nextToken());
			arr[i][2] =Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr,int n) {
		int answer = 0;
		for(int i=1;i<n;++i) {
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
			arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
		}
		answer = Math.min(Math.min(arr[n-1][0], arr[n-1][1]),arr[n-1][2]);
		
		return answer;
	}

}
