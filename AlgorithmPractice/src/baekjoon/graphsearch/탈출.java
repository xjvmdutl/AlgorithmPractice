package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Info{
	int x;
	int y;
	public Info(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class ≈ª√‚ {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int[][] visit;
	public static Queue<Info> waters;
	public static Queue<Info> bef;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		char[][] arr = new char[r][c];
		for(int i=0;i<r;++i) {
			arr[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(arr,r,c));
	}

	private static String solution(char[][] arr, int r, int c) {
		visit = new int[r][c];
		waters = new LinkedList<>();
		bef = new LinkedList<>();
		int resultX = 0;
		int resultY = 0;
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(arr[i][j] == '*') {
					waters.offer(new Info(j, i));
				}
				if(arr[i][j] == 'S') {
					visit[i][j] = 1;
					bef.offer(new Info(j, i));
				}
				if(arr[i][j] == 'D') {
					resultX = j;
					resultY = i;
				}
			}
		}
		while(!bef.isEmpty()) {
			
			spread(arr,r,c);
			bfs(arr,r,c);
			if(visit[resultY][resultX] != 0) {
				return String.valueOf(visit[resultY][resultX] - 1);
			}
		}
		return "KAKTUS";
	}

	private static void bfs(char[][] arr, int r, int c) {
		int cnt = bef.size();
		while(cnt-- > 0) {
			Info info =  bef.poll();
			for(int i=0;i<4;++i) {
				int x = info.x + dx[i];
				int y = info.y + dy[i];
				if(!isRange(arr,r,c,x,y)) continue;
				if(visit[y][x] == 0) {
					
					if( arr[y][x] == 'D') {
						visit[y][x] = visit[info.y][info.x] + 1;
						return;
					}
					if(arr[y][x] == '.' ) {
						visit[y][x] = visit[info.y][info.x] + 1;
						bef.offer(new Info(x,y));
					}
				}
			}
		}
	}

	private static void spread(char[][] arr, int r, int c) {
		int cnt = waters.size();
		while(cnt-- > 0) {
			Info info = waters.poll();
			for(int i=0;i<4;++i) {
				int x = info.x + dx[i];
				int y = info.y + dy[i];
				if(!isRange(arr,r,c,x,y)) continue;
				if(arr[y][x] == '.') {
					arr[y][x] = '*';
					waters.offer(new Info(x,y));
				}
			}
		}
	}

	private static boolean isRange(char[][] arr, int r, int c, int x, int y) {
		if(x < 0 || x >= c || y < 0 || y >= r)
			return false;
		return true;
	}

	

}
