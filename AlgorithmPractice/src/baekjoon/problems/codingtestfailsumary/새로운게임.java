package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Horse{
	int x;
	int y;
	int dir;
	public Horse(int x,int y,int dir) {
		this.dir= dir;
		this.x = x;
		this.y = y;
	}
}
public class 새로운게임 {
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[] change = {1,0,3,2};
	public static List<Integer>[][] state;
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
		Horse[] horses = new Horse[k];
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(tokens.nextToken()) - 1;
			int x = Integer.parseInt(tokens.nextToken()) - 1;
			int dir = Integer.parseInt(tokens.nextToken()) - 1;
			state[y][x].add(i);
			horses[i] = new Horse(x, y, dir);
		}
		System.out.println(solution(map,horses,n,k));
	}
	private static int solution(int[][] map, Horse[] horses, int n, int k) {
		int answer = 0;
		boolean flag = true;
		while(flag) {
			answer++;
			if(answer > 1000)
				break;
			for(int i=0;i<k;++i) {
				Horse h = horses[i];
				int x = h.x;
				int y = h.y;
				if(state[y][x].get(0) != i) {
					continue;
				}
				int nx = x + dx[h.dir];
				int ny = y + dy[h.dir];
				if(!isRange(nx,ny,n) || map[ny][nx] == 2) {
					h.dir = change[h.dir];
					nx = x + dx[h.dir];
					ny = y + dy[h.dir];
				}
				if(!isRange(nx, ny, n) || map[ny][nx] == 2) {
					continue;
				}else if(map[ny][nx] == 1) {
					for(int j=state[y][x].size()-1;j>=0;--j) {
						int now = state[y][x].get(j);
						horses[now].x = nx;
						horses[now].y = ny;
						state[ny][nx].add(now);
					}
					state[y][x].clear();
				}else {
					for(int j=0;j<state[y][x].size();++j) {
						int now = state[y][x].get(j);
						horses[now].x = nx;
						horses[now].y = ny;
						state[ny][nx].add(now);
					}
					state[y][x].clear();
				}
				if(state[ny][nx].size() >= 4) {
					flag = false;
				}
			}
		}
		return flag ? -1 : answer;
	}
	private static boolean isRange(int x, int y, int n) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

}
