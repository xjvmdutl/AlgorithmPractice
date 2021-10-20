package baekjoon.problems.samsungSwTest;

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
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
}
public class 새로운게임2 {
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[] change = {1,0,3,2};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		List<Integer>[][] list = new ArrayList[n][n];
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}
		Horse[] horses = new Horse[k];
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(tokens.nextToken()) - 1;
			int x = Integer.parseInt(tokens.nextToken()) - 1;
			int dir = Integer.parseInt(tokens.nextToken()) - 1;
			horses[i] = new Horse(x, y, dir);
			list[y][x].add(i);
		}
		
		System.out.println(solution(list,map,n,horses));
	}
	
	private static int solution(List<Integer>[][] list, int[][] map, int n, Horse[] horses) {
		int answer = 0;
		boolean flag = false;
		while(!flag) {
			answer++;
			if(answer > 1000)
				break;
			for(int i=0;i<horses.length;++i) {
				int x = horses[i].x;
				int y = horses[i].y;
				int dir = horses[i].dir;
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(!isRange(nx, ny, n) || map[ny][nx] == 2) {
					dir = change[dir];
					nx = x + dx[dir];
					ny = y + dy[dir];
				}
				horses[i].dir = dir;
				if(!isRange(nx, ny, n) || map[ny][nx] == 2) {
					continue;
				}else if(map[ny][nx] == 0) {
					
					int index = list[y][x].indexOf(i);
					while(list[y][x].size() != index) {
						int now = list[y][x].get(index);
						list[ny][nx].add(list[y][x].get(index));
						list[y][x].remove(index);
						horses[now].x = nx;
						horses[now].y = ny;
					}
				}else {
					int index = list[y][x].indexOf(i);
					while(list[y][x].size() != index) {
						int last = list[y][x].size() - 1;
						int now = list[y][x].get(last);
						list[ny][nx].add(list[y][x].get(last));
						list[y][x].remove(last);
						horses[now].x = nx;
						horses[now].y = ny;
					}
				}
				
				if(list[ny][nx].size() >= 4) {
					flag = true;
					break;
				}
			}
		}
		return !flag ? -1 : answer;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
