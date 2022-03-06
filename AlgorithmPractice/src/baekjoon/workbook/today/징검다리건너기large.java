package baekjoon.workbook.today;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리건너기large {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] arr = new long[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static long solution(long[] arr, int n) {
		long answer =  Long.MAX_VALUE;
		long start = 0;
		long end = Long.MAX_VALUE;
		while(start <= end) {
			long mid = (start + end) / 2;
			boolean[] dp = new boolean[n];
			dp[0] = true;
			for(int i=0;i<n;++i) {
				if(dp[i]) {
					for(int j=i+1;j<n;++j) {
						long power = (j-i) * (1 + Math.abs(arr[i]-arr[j]));
						if(power <= mid)
							dp[j] = true;
					}
					if(dp[n-1])
						break;
				}
			}
			if(dp[n-1]) {
				end = mid - 1;
				answer = Math.min(answer, mid);
			}else {
				start = mid + 1;
			}
		}
		return answer;
	}

}

