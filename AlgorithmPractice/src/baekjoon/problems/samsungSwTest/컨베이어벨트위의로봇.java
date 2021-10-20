package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {
	public static int answer;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[2*n];
		for(int i=0;i<2*n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,k));
	}

	private static int solution(int[] arr, int n, int k) {
		answer = 0;
		visit = new boolean[n];
		dfs(arr,n,1,k);
		return answer;
	}

	private static void dfs(int[] arr, int n,int count, int k) {
		int tmp = arr[arr.length-1];
		for(int i=2*n-1;i>0;--i) {
			arr[i] = arr[i-1];
		}
		arr[0] = tmp;
		for(int i=n-1;i>0;--i) {
			visit[i] = visit[i-1];
		}
		visit[0] = false;
		visit[n-1] = false;
		for(int i=n-1;i>0;--i) {
			if(visit[i-1] && !visit[i] && arr[i] >= 1) {
				arr[i]--;
				visit[i-1] = false;
				visit[i] = true;
			}
		}
		
		if(arr[0] > 0) {
			visit[0] = true;
			arr[0]--;
		}
		int cnt = 0;
		for(int i=0;i<2*n;++i) {
			if(arr[i] == 0)
				cnt++;
		}
		if(cnt >= k) {
			answer = count;
			return;
		}
		dfs(arr, n, count+1, k);
		
	}

}
