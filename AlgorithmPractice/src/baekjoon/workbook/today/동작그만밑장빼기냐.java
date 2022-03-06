package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class µ¿ÀÛ±×¸¸¹ØÀå»©±â³Ä {

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
		int[][] sum = new int[2][n/2 + 1];
		for(int i=2;i<n+2;++i) {
			int row = i%2;
			int col = i/2;
			sum[row][col] = sum[row][col-1] + arr[i - 2]; 
		}
		int[] dp = new int[n];
		for(int i=1;i<=n;++i) {
			//i¹øÂ° ¹ØÀå
			//È¦¼ö index
			if(i % 2 == 1) {
				//10 + 2 + 4 + 6 + 8 //sum[0][0] + (sum[1][4] - sum[1][0]) + arr[n-1]
				//1 + 10 + 4 + 6 + 8 //sum[0][1] + (sum[1][4] - sum[1][1]) + arr[n-1]
				//1 + 3 + 10 + 6 + 8 //sum[0][2] + (sum[1][4] - sum[1][2]) + arr[n-1]
				//1 + 3 + 5 + 10 + 8 //sum[0][3] + (sum[1][4] - sum[1][3]) + arr[n-1]
				//1 + 3 + 5 + 7 + 10 //sum[0][4] + (sum[1][4] - sum[1][4]) + arr[n-1]
				dp[i-1] = sum[0][(i-1)/2] + (sum[1][(n-2)/2] - sum[1][(i-1)/2]) + arr[n-1];
			}else {
				//1 + 2 + 4 + 6 + 8 //sum[0][1] + (sum[1][4] - sum[1][0])
				//1 + 3 + 4 + 6 + 8 //sum[0][2] + (sum[1][4] - sum[1][1])
				//1 + 3 + 5 + 6 + 8 //sum[0][3] + (sum[1][4] - sum[1][2])
				//1 + 3 + 5 + 7 + 8 //sum[0][4] + (sum[1][4] - sum[1][3])
				//1 + 3 + 5 + 7 + 9 //sum[0][5] + (sum[1][4] - sum[1][4])
				dp[i-1] = sum[0][i/2] + (sum[1][(n-2)/2] - sum[1][(i-1)/2]);
			}
			answer = Math.max(dp[i-1], answer);
			
		}
		return answer;
	}

}
