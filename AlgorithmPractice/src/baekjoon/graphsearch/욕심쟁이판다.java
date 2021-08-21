package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class panda{
	int x;
	int y;
	int eat;
	public panda(int x,int y,int eat) {
		this.x = x;
		this.y = y;
		this.eat = eat;
	}
}
public class øÂΩ…¿Ô¿Ã∆«¥Ÿ {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		dp = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				answer = Math.max(dfs(arr,j,i,n),answer);
			}
		}
		return answer;
	}

	private static int dfs(int[][] arr, int x, int y, int n) {
		if(dp[y][x] != 0)
			return dp[y][x];
		dp[y][x] = 1;
		for(int i=0;i<4;++i) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0 <= nx && nx < n && 0 <= ny && ny < n) {
				if( arr[y][x] < arr[ny][nx]) {
					dfs(arr,x,y,n);
					dp[y][x] = Math.max(dp[y][x], dfs(arr,nx, ny,n) + 1);
				}
			}
		}
		
		return dp[y][x];
		
		
	}

}
