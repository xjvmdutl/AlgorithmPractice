package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Land{
	int x;
	int y;
	public Land(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class º¸¹°¼¶ {
	public static int[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] arr = new char[n][m];
		for(int i=0;i<n;++i) {
			arr[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(arr,n,m));
	}
	private static int solution(char[][] arr, int n, int m) {
		int answer = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(arr[i][j] == 'L') {
					visit = new int[n][m];
					answer = Math.max(bfs(arr,j,i),answer);					
				}
			}	
		}
		return answer;
	}
	private static int bfs(char[][] arr, int x, int y) {
		Queue<Land> que = new LinkedList<>();
		que.offer(new Land(x,y));
		visit[y][x] = 1;
		int cnt = 0;
		while(!que.isEmpty()) {
			Land l = que.poll();
			for(int i=0;i<4;++i) {
				int nx = dx[i] + l.x;
				int ny = dy[i] + l.y;
				if(0 <= nx && nx < arr[0].length && 0 <= ny && ny < arr.length) {
					if(visit[ny][nx] == 0 && arr[ny][nx] == 'L') {
						visit[ny][nx] = visit[l.y][l.x] + 1;
						que.offer(new Land(nx, ny));
						cnt = Math.max(visit[ny][nx], cnt);
					}
				}
			}
		}
		
		return cnt-1;
	}

}
