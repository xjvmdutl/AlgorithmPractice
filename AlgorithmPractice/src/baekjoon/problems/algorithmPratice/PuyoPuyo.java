package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
class Puyo{
	int x;
	int y;
	public Puyo(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class PuyoPuyo {
	public static boolean[][] visit;
	public static boolean[][] remove;
	public static boolean flag;
	public static int answer;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = 12;
		int m = 6;
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(char[][] map, int n, int m) {
		answer = 0;
		while(true) {
			visit = new boolean[n][m];
			remove = new boolean[n][m];
			flag = false;
			for(int i=0;i<n;++i) {
				for(int j=0;j<m;++j) {
					if(!visit[i][j] && map[i][j] != '.') {
						bfs(map,n,m,j,i);
					}
				}
			}
			if(!flag) {
				break;
			}
			answer++;
			remove(map,n,m);
			
		}
		return answer;
	}

	private static void remove(char[][] map, int n, int m) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(remove[i][j])
					map[i][j] = '.';
			}	
		}
		for(int j=0;j<m;++j) {
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<n;++i) {
				char now = map[i][j];
				if(now != '.') {
					stack.push(now);
				}
				map[i][j] = '.';
			}
			int size = n-stack.size();
			for(int i=n-1;i>=size;--i) {
				map[i][j] = stack.pop();
			}
		}	
		
	}

	private static void bfs(char[][] map, int n, int m, int x, int y) {
		char c = map[y][x];
		Queue<Puyo> que = new LinkedList<>();
		List<Puyo> removeList = new ArrayList<>();
		visit[y][x] = true;
		que.offer(new Puyo(x, y));
		while(!que.isEmpty()) {
			Puyo p = que.poll();
			removeList.add(p);
			for(int i=0;i<4;++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(isRange(nx,ny,n,m) && !visit[ny][nx] && map[ny][nx] == c) {
					visit[ny][nx] = true;
					que.offer(new Puyo(nx, ny));
				}
			}
		}
		if(removeList.size() >= 4) {
			flag = true;
			
			for(Puyo p:removeList) {
				remove[p.y][p.x] = true; 
			}
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0<=nx&&nx<m&&0<=ny&&ny<n;
	}

}
