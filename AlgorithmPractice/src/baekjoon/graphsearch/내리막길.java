package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Road{
	int x;
	int y;
	public Road(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 내리막길 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[][] dp;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n,m));
	}

	private static int solution(int[][] arr, int n, int m) {
		answer = 0;
		dp = new int[n][m];
		for(int i=0;i<n;++i) {
			Arrays.fill(dp[i],-1);
		}
		answer = dfs(arr,n,m,0,0);
		return answer;
	}

	private static int dfs(int[][] arr, int n, int m, int x, int y) {
		
		if(y == n-1 && x == m-1) {
			return 1;
		}
		if (dp[y][x] != -1) {
            //-1이 아닌 경우는 이미 방문했다(메모이제이션)
            return dp[y][x];
        }else {
            dp[y][x] = 0;
            for(int i=0;i<4;++i) {
    			int nx = dx[i] + x;
    			int ny = dy[i] + y;
    			if(0 <= nx && nx < m && 0 <= ny && ny < n) {
    				if(arr[y][x] > arr[ny][nx]) {
    					dp[y][x] += dfs(arr, n, m, nx, ny);
    				}
    			}
    		}
        }

        return dp[y][x];
		
		
	}
}
