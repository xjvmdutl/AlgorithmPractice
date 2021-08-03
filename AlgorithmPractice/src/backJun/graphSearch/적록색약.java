package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적록색약 {
	public static boolean[][] visited;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		char[][] arr = new char[n][n];
		for(int i=0;i<n;++i) {
			arr[i] = reader.readLine().toCharArray();
		}
		int no = solution1(arr,n);
		int yes = solution2(arr,n);
		System.out.println(no + " " + yes);
	}
	
	private static int solution1(char[][] arr, int n) {
		int answer = 0;
		visited = new boolean[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(!visited[i][j]) {
					answer++;
					visited[i][j] = true;
					dfs(arr,j,i,n);
				}
			}
		}
		return answer;
	}
	
	private static void dfs(char[][] arr, int x, int y, int n) {
		char c = arr[y][x]; 
		for(int i=0;i<4;++i) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(0 <= tx && tx < n && 0 <= ty && ty < n) {
				if(!visited[ty][tx] && arr[ty][tx] == c) {
					visited[ty][tx] = true;
					dfs(arr,tx,ty,n);
				}
			}
		}
	}

	private static int solution2(char[][] arr, int n) {
		int answer = 0;
		visited = new boolean[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(!visited[i][j]) {
					answer++;
					visited[i][j] = true;
					Nodfs(arr,j,i,n);
				}
			}
		}
		return answer;
	}
	private static void Nodfs(char[][] arr, int x, int y, int n) {
		char c = arr[y][x]; 
		for(int i=0;i<4;++i) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(0 <= tx && tx < n && 0 <= ty && ty < n) {
				if(!visited[ty][tx]) {
					if(arr[ty][tx] == c) {
						visited[ty][tx] = true;
						Nodfs(arr,tx,ty,n);
					}else if((c == 'R' || c == 'G')
							&& (arr[ty][tx] == 'R' || arr[ty][tx] == 'G')) {
						visited[ty][tx] = true;
						Nodfs(arr,tx,ty,n);
					}
				}
			}
		}
	}
	

}
