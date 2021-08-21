package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Iceberg{
	int x;
	int y;
	public Iceberg(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class ºù»ê {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visit;
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
		int day = 0;
		while(true) {
			
			int answer = 0;
			visit = new boolean[n][m];
			
			for(int i=0;i<n;++i) {
				for(int j=0;j<m;++j) {
					if(arr[i][j] != 0 && !visit[i][j]) {
						answer++;
						visit[i][j] = true;
						bfs(arr,j,i);
					}
				}	
			}
			if(answer >= 2)
				break;
			if(answer == 0) {
				day = 0;
				break;
			}
			day++;
		}
		return day;
	}

	private static void bfs(int[][] arr, int j, int i) {
		Queue<Iceberg> que = new LinkedList<Iceberg>();
		que.offer(new Iceberg(j, i));
		while(!que.isEmpty()) {
			Iceberg ice = que.poll();
			for(int k=0;k<4;++k) {
				int x = dx[k] + ice.x;
				int y = dy[k] + ice.y;
				if(0 <= x && x < arr[0].length && 0 <= y && y< arr.length) {
					if(!visit[y][x] && arr[y][x] != 0) {
						visit[y][x] = true;
						que.offer(new Iceberg(x, y));
					}
					if(!visit[y][x] && arr[y][x] == 0) {
						arr[ice.y][ice.x] -= 1;
						if(arr[ice.y][ice.x] < 0) {
							arr[ice.y][ice.x] = 0;
							continue;
						}
					}
				}
			}
		}
	}

}
