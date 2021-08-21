package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Bridge{
	int x;
	int y;
	int count;
	public Bridge(int x,int y,int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
public class 다리만들기 {
	
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visit;
	public static int[][] map;
	public static int answer;
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
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, int[][] arr) {
		answer = Integer.MAX_VALUE;
		visit = new boolean[n][n];
		int cnt = 1;
		map = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					makeLand(arr,j,i,n,cnt++);
				}
			}
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] >= 1 ) {
					visit = new boolean[n][n];
					bfs(arr,j,i,n,map[i][j]);
				}
			}
		}
		
		return answer;
	}

	private static void bfs(int[][] arr, int x, int y, int n,int cnt) {
		Queue<Bridge> que = new LinkedList<>();
		que.offer(new Bridge(x, y,0));
		visit[y][x] = true;
		while(!que.isEmpty()) {
			Bridge b = que.poll();
			for(int i=0;i<4;++i) {
				int nx = dx[i] + b.x;
				int ny = dy[i] + b.y;
				if(0 <= nx && nx < n && 0 <= ny && ny < n) {
					if(!visit[ny][nx]) {
						if(map[ny][nx] == 0) {
							que.offer(new Bridge(nx, ny,b.count+1));
							visit[ny][nx] = true;
						}else if(cnt != map[ny][nx]){
							answer = Math.min(answer, b.count);
						}
					}
				}
			}
		}
	}

	private static void makeLand(int[][] arr, int x, int y, int n, int cnt) {
		Queue<Bridge> que = new LinkedList<>();
		que.offer(new Bridge(x, y,0));
		visit[y][x] = true;
		map[y][x] = cnt;
		while(!que.isEmpty()) {
			Bridge b = que.poll();
			for(int i=0;i<4;++i) {
				int nx = dx[i] + b.x;
				int ny = dy[i] + b.y;
				if(0 <= nx && nx < n && 0 <= ny && ny < n) {
					if(!visit[ny][nx] && arr[ny][nx] == 1) {
						que.offer(new Bridge(nx, ny,0));
						visit[ny][nx] = true;
						map[ny][nx] = cnt;
					}
				}
			}
		}
	}

}
