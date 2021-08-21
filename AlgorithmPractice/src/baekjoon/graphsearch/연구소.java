package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Virus{
	int x;
	int y;
	public Virus(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 연구소 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int answer;
	public static void main(String[] args) throws IOException {
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
		dfs(arr,n,m,0);
		return answer;
	}

	private static void dfs(int[][] arr,int n ,int m, int count) {
		if(count == 3) {
			bfs(arr,n,m);
			return;
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(arr, n, m, count+1);
					arr[i][j] = 0;
				}
			}
		}
	}

	private static void bfs(int[][] arr, int n, int m) {
		Queue<Virus> queue = new LinkedList<>();
		int[][] virusMap = new int[n][m];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				virusMap[i][j] = arr[i][j];//복사
				if(arr[i][j] == 2) {
					queue.offer(new Virus(j, i));
				}
			}
		}
		while(!queue.isEmpty()) {
			Virus v = queue.poll();
			for(int i=0;i<4;++i) {
				int x = v.x + dx[i];
				int y = v.y + dy[i];
				if(0 <= x && x < m && 0 <= y && y < n) {
					if(virusMap[y][x] == 0) {
						virusMap[y][x] = 2;
						queue.offer(new Virus(x, y));
					}
				}
			}
		}
		Counting(virusMap,n,m);
		
	}

	private static void Counting(int[][] virusMap, int n, int m) {
		int count = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(virusMap[i][j] == 0)
					count++;
			}
		}
		answer = Math.max(answer, count);
	} 

	
}
