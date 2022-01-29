package baekjoon.workbook.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기 {
	public static int[] breaken;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] arr = new int[N][2];
		for(int i=0;i<N;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,N));
	}

	private static int solution(int[][] arr, int n) {
		answer = 0;
		breaken = new int[n];
		for(int i=0;i<n;++i) {
			breaken[i] = arr[i][0];
		}
		permulate(arr,0,n);
		return answer;
	}

	private static void permulate(int[][] arr, int now, int n) {
		if(now == n) {
			int count = 0;
			for(int i=0;i<n;++i) {
				if(breaken[i] <= 0)
					count++;
			}
			answer = Math.max(answer, count);
			return;
		}
		int broke = 0;
		for(int i=0;i<n;++i) {
			if(breaken[now] <= 0 || arr[now][0] < 0 || broke == (n-1)) {
				permulate(arr, now+1, n);
			}else if(breaken[i] <= 0) {
				broke++;
				continue;
			}else if(i != now && breaken[i] > 0) {
				breaken[now] -= arr[i][1];
				breaken[i] -= arr[now][1];
				permulate(arr, now+1, n);
				breaken[now] += arr[i][1];
				breaken[i] += arr[now][1];
			}
		}
	}
	

}
