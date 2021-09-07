package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 하나로만들기 {
	public static int[] dp = new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		bfs(n);
		return dp[1];
	}

	private static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(n);
		while(!que.isEmpty()) {
			int num =que.poll();
			if(num <= 1) {
				break;
			}
			if(num%3 == 0 && dp[num/3] == 0) {
				dp[num/3]= dp[num] + 1 ;
				que.offer(num/3);
			}
			if(num%2 == 0 && dp[num/2] == 0) {
				dp[num/2]= dp[num] + 1 ;
				que.offer(num/2);
			}
			if(dp[num-1] == 0) {
				dp[num-1]= dp[num] + 1 ;
				que.offer(num-1);
			}
		}
	}

}
