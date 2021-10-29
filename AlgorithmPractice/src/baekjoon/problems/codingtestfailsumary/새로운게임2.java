package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Horse01{
	int x;
	int y;
	int dir;
	public Horse01(int x,int y,int dir) {
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
}
public class 새로운게임2 {
	public static List<Integer>[][] state;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[] changeDir = {1,0,3,2};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		state = new ArrayList[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				state[i][j] = new ArrayList<>();
			}
		}
		Horse01[] horses = new Horse01[k];
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(tokens.nextToken()) - 1;
			int x = Integer.parseInt(tokens.nextToken()) - 1;
			int dir = Integer.parseInt(tokens.nextToken()) - 1;
			state[y][x].add(i);
			horses[i] = new Horse01(x, y, dir);
		}
		System.out.println(solution(map,horses,n,k));
	}
	private static int solution(int[][] map, Horse01[] horses, int n, int k) {
		int time = 0;
		boolean flag = true;
		while(flag) {
			time++;
			if(time > 1000)
				return -1;
			for(int i=0;i<horses.length;++i) {
				int x = horses[i].x;
				int y = horses[i].y;
				int dir = horses[i].dir;
				int nx = horses[i].x + dx[dir];
				int ny = horses[i].y + dy[dir];
				if(!isRange(nx,ny,n) || map[ny][nx] == 2 ) {
					dir = changeDir[dir];
					nx = x + dx[dir];
					ny = y + dy[dir];
				}
				horses[i].dir = dir;
				if(!isRange(nx,ny,n) || map[ny][nx] == 2 ) {
					continue;
				}else if(map[ny][nx] == 1) {
					int idx = state[y][x].indexOf(i);
					int size = state[y][x].size();
					for(int j=idx;j<size;++j) {
						int now = state[y][x].get(state[y][x].size()-1);
						state[ny][nx].add(now);
						state[y][x].remove(state[y][x].size()-1);
						horses[now].x = nx;
						horses[now].y = ny;
					}
				}else {
					int idx = state[y][x].indexOf(i);
					int size = state[y][x].size();
					for(int j=idx;j<size;++j) {
						int now = state[y][x].get(idx);
						state[ny][nx].add(now);
						state[y][x].remove(idx);
						horses[now].x = nx;
						horses[now].y = ny;
					}
				}
				if(state[ny][nx].size() >= 4) {
					flag = false;
					break;
				}
			}
		}
		return !flag ? time : -1;
	}
	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}
}
