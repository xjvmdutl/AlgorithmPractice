package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class 스타트와링크 {
	public static int answer;
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new  StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		answer = Integer.MAX_VALUE;
		visit = new boolean[n];
		dfs(arr,0,0,n);
		return answer;
	}

	private static void dfs(int[][] arr,int count,int index, int n) {
		if(count == n/2) {
			diff(arr,n);
			return;
		}
		for(int i=index;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(arr,count+1, i+1, n);
				visit[i] = false;
			}
			
		}
	}

	private static void diff(int[][] arr, int n) {
		int team_start = 0;
		int team_link = 0;
		for (int i = 0; i < n -1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (visit[i] == true && visit[j] == true) {
					team_start += arr[i][j];
					team_start += arr[j][i];
				}else if (visit[i] == false && visit[j] == false) {
					team_link += arr[i][j];
					team_link += arr[j][i];
				}
			}
		}
		int abs= Math.abs(team_link - team_start);
		if(abs == 0) {
			System.out.println(abs);
			System.exit(0);
		}
		answer = Math.min(abs, answer);
	}

}
