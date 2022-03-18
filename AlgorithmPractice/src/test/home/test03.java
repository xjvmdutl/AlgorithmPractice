package test.home;

import java.util.LinkedList;
import java.util.Queue;

class Block{
	int x;
	int y;
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class test03 {
	private static final int INF = 1000000007;
	private static boolean[][] visit;
	private static boolean[][] now;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		int[] decos1 = {2, 3};
		String[] grid1 = {"###.#","..#.#","###.#","#..##","###.."};
		System.out.println(solution(decos1, grid1));
	}

	private static int solution(int[] decos, String[] grid) {
		int answer = 1;
		int n = grid.length;
		int m = grid[0].length();
		visit = new boolean[n][m];
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = grid[i].toCharArray();
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(!visit[i][j] && map[i][j] == '#') {
					now = new boolean[n][m]; 
					bfs(map, j, i, n, m);
					permutation(map, decos, n, m, j, i);
				}
			}	
		}
		
		return answer;
	}

	private static void permutation(char[][] map, int[] decos, int n, int m, int x, int y) {
		int count = 0;
		for(int i=0;i<decos.length;++i) {
			OUTER:for(int j=0;j<4;++j) {
				int nx = x + (dx[i] * decos[i]);
				int ny = y + (dy[i] * decos[i]);
				if(isRange(nx, ny, n, m) ) {
					for(int k=x;k<=nx;++k) {
						//if(visit[])
					}
				}
			}
		}
	}

	private static void bfs(char[][] map, int x, int y, int n, int m) {
		Queue<Block> que = new LinkedList<>();
		visit[y][x] = true;
		now[y][x] = true;
		que.offer(new Block(x, y));
		while(!que.isEmpty()) {
			Block b = que.poll();
			for(int i=0;i<4;++i) {
				int nx = b.x + dx[i];
				int ny = b.y + dy[i];
				if(isRange(nx, ny, n, m) && map[ny][nx] == '#' && !visit[ny][nx]) {
					visit[ny][nx] = true;
					now[ny][nx] = true;
					que.offer(new Block(nx, ny));
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
}
