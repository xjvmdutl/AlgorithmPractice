package backJun.stepBystep.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¿Ø±‚≥ÛπË√ﬂ {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			String[] strs = reader.readLine().split(" ");
			int m = Integer.parseInt(strs[0]);
			int n = Integer.parseInt(strs[1]);
			int k = Integer.parseInt(strs[2]);
			
			int[][] arr = new int[n][m];
			for(int j=0;j<k;++j) {
				strs = reader.readLine().split(" ");
				int x = Integer.parseInt(strs[0]);
				int y = Integer.parseInt(strs[1]);
				arr[y][x] = 1;
			}
			System.out.println(solution(arr,n,m));
		}
	}

	private static int solution(int[][] arr, int n, int m) {
		int answer = 0;
		visited = new boolean[n][m];
		for(int i=0;i<n;++i) {
			for(int j=0;j<arr[i].length;++j) {
				if(arr[i][j] != 0 && !visited[i][j]) {
					answer++;
					visited[i][j] = true;
					dfs(arr,j,i,n,m);
				}
			}
		}
		
		return answer;
	}

	private static void dfs(int[][] arr, int x, int y,int n,int m) {
		for(int i=0;i<4;++i) {
			int jdx = x + dx[i];
			int idx = y + dy[i];
			if(0 <= jdx && jdx < m && 0 <= idx && idx <n) {
				if(!visited[idx][jdx] && arr[idx][jdx] != 0) {
					visited[idx][jdx] = true;
					dfs(arr,jdx,idx,n,m);
				}
			}
		}
	}

}
