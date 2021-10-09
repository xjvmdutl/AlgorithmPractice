package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Marble{
	int rx;
	int ry;
	int bx;
	int by;
	int count;
	public Marble(int rx,int ry,int bx,int by,int count) {
		this.bx = bx;
		this.by = by;
		this.count= count;
		this.rx = rx;
		this.ry = ry;
	}
}
public class ±∏ΩΩ≈ª√‚2 {
	public static boolean[][][][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<m;++j) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(char[][] map, int n, int m) {
		visit = new boolean[n][m][n][m];
		Marble red = null;
		Marble blue = null;
		int goalX = 0;
		int goalY = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] == 'R') {
					red = new Marble(j, i, 0, 0, 0);
				}else if(map[i][j] == 'B') {
					blue = new Marble(0, 0, j, i, 0);
				}else if(map[i][j] == 'O') {
					goalX = j;
					goalY = i;
				}
			}
		}
		int answer = bfs(map,n,m,red,blue,goalX,goalY);
		
		return answer;
	}

	private static int bfs(char[][] map, int n, int m, Marble red, Marble blue, int goalX, int goalY) {
		Queue<Marble> que = new LinkedList<>();
		que.offer(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
		visit[red.ry][red.rx][blue.by][blue.bx] = true;
		while(!que.isEmpty()) {
			Marble marble = que.poll();
			if(marble.count > 10) {
				return -1;
			}
			for(int i=0;i<4;++i) {
				int nRx = marble.rx;
				int nRy = marble.ry;
				int nBx = marble.bx;
				int nBy = marble.by;
				
				boolean isRedHoleIn = false;
				boolean isBlueHoleIn = false;
				while(map[nRy + dy[i]][nRx + dx[i]] != '#') {
					nRx += dx[i];
					nRy += dy[i];
					if(map[nRy][nRx] == 'O') {
						isRedHoleIn = true;
						break;
					}
				}
				while(map[nBy + dy[i]][nBx + dx[i]] != '#') {
					nBx += dx[i];
					nBy += dy[i];
					if(map[nBy][nBx] == 'O') {
						isBlueHoleIn = true;
						break;
					}
				}
				if(isBlueHoleIn) {
					continue;
				}else if(isRedHoleIn) {
					return marble.count;
				}
				if(nRx == nBx && nRy == nBy) {
					int rx = marble.rx;
					int ry = marble.ry;
					int bx = marble.bx;
					int by = marble.by;
					if(i == 0) {
						if(rx < bx) nBx -= dx[i];
						else nRx -= dx[i];
					}else if(i == 1) {
						if(rx < bx) nRx -= dx[i];
						else nBx -= dx[i];
					}else if(i == 2) {
						if(ry < by) nRy -= dy[i];
						else nBy -= dy[i];
					}else if(i == 3) {
						if(ry < by) nBy -= dy[i];
						else nRy -= dy[i];
					}
				}
				if(!visit[nRy][nRx][nBy][nBx]) {
					visit[nRy][nRx][nBy][nBx] = true;
					que.offer(new Marble(nRx, nRy, nBx, nBy, marble.count+1));
				}
				
			}
		}
		return -1;
	}
}
