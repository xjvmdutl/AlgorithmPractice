package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point02{
	int x;
	int y;
	public Point02(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 인구이동 {
	public static int[][] visit;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int l = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n,l,r));
	}

	private static int  solution(int[][] arr, int n, int l, int r) {
		int answer = 0;
		while(true) {
			int cnt = 0;
			visit = new int[n][n];
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(visit[i][j] == 0) {
						cnt++;
						visit[i][j] = cnt;
						bfs(arr,n,l,r,i,j,cnt);
					}
				}
			}
			if(n * n == cnt)
				break;
			
			int[] list = new int[cnt];
			int[] person = new int[cnt];
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					list[visit[i][j]-1] += arr[i][j];
					person[visit[i][j]-1]++;
				}
			}
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					arr[i][j] =  list[visit[i][j]-1] / person[visit[i][j]-1];
				}
			}
			answer++;
		}
		return answer;
	}

	private static void bfs(int[][] arr, int n, int l, int r, int i, int j, int cnt) {
		Queue<Point02> que = new LinkedList<>();
		que.offer(new Point02(j, i));
		while(!que.isEmpty()) {
			Point02 p = que.poll();
			for(int idx=0;idx<4;++idx) {
				int x = dx[idx] + p.x;
				int y = dy[idx] + p.y;
				if(0 <= x && x < n && 0 <= y && y < n) {
					if(visit[y][x] == 0 ) {
						int diff = Math.abs(arr[p.y][p.x] - arr[y][x]); 
						if(l <= diff && diff <= r) {
							visit[y][x] = cnt;
							que.offer(new Point02(x, y));
						}
						
					}
				}
			}
		}
		
	}

}
