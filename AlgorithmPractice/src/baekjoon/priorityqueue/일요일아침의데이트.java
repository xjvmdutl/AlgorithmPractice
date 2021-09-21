package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Forest implements Comparable<Forest>{
	int x;
	int y;
	int garbageCount;
	int garbageSideCount;
	public Forest(int x,int y,int garbageCount,int garbageSideCount) {
		this.x = x;
		this.y = y;
		this.garbageCount = garbageCount;
		this.garbageSideCount = garbageSideCount;
	}

	@Override
	public int compareTo(Forest o) {
		if(this.garbageCount == o.garbageCount)
			return this.garbageSideCount - o.garbageSideCount;
		return this.garbageCount - o.garbageCount;
	}
}
public class 일요일아침의데이트 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visit;
	public static int gc;
	public static int gsc;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] arr = new char[n][m];
		int startX = 0;
		int startY = 0;
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<m;++j) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'S') {
					startX = j;
					startY = i;
				}
			}
		}
		System.out.println(solution(arr,n,m,startX,startY));
	}

	private static String solution(char[][] arr, int n, int m, int startX, int startY) {
		StringBuilder sb = new StringBuilder();
		visit = new boolean[n][m];
		gc = 0;
		gsc = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(arr[i][j] == 'g') {
					for(int k=0;k<4;++k) {
						int x = dx[k] + j;
						int y = dy[k] + i;
						if(0 <= x && x < m && 0 <= y && y < n) {
							if(arr[y][x] == '.') {
								arr[y][x] = 'c';
							}
						}
					}
				}
			}
		}
		bfs(arr,startX,startY,n,m);
		sb.append(gc + " " +gsc);
		return sb.toString();
	}

	private static void bfs(char[][] arr, int startX, int startY, int n, int m) {
		Queue<Forest> que = new PriorityQueue<>();
		visit[startY][startX] = true;
		que.offer(new Forest(startX, startY, 0, 0));
		while(!que.isEmpty()) {
			Forest f = que.poll();
			if(arr[f.y][f.x] == 'F') {
				gc = f.garbageCount;
				gsc = f.garbageSideCount;
				break;
			}
			for(int i=0;i<4;++i) {
				int x = dx[i] + f.x;
				int y = dy[i] + f.y;
				if(0 <= x && x < m && 0 <= y && y < n) {
					if(!visit[y][x]) {
						if(arr[y][x] == 'g') {
							visit[y][x] = true;
							que.offer(new Forest(x, y, f.garbageCount+1, f.garbageSideCount));
						}else if(arr[y][x] == 'c') {
							visit[y][x] = true;
							que.offer(new Forest(x, y, f.garbageCount, f.garbageSideCount+1));
						}else{
							visit[y][x] = true;
							que.offer(new Forest(x, y, f.garbageCount, f.garbageSideCount));
						}
					}
				}
			}
		}
	}

}
