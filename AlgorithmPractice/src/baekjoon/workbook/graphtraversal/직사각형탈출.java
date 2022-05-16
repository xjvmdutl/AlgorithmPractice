package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출 {
	private static final int[] dx = {-1, 1, 0, 0}; 
	private static final int[] dy = {0, 0, -1, 1};
	static class Square implements Comparable<Square>{
		int x;
		int y;
		int dis;
		public Square(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		@Override
		public int compareTo(Square o) {
			return this.dis - o.dis;
		}
		
		public boolean isGoal(int eRow, int eCol) {
			return this.x == eCol - 1
					&& this.y == eRow - 1;
		}
		
	}
	private static int solution(int[][] map, int n, int m, int h, int w, int sRow, int sCol, int eRow, int eCol) {
		int answer = bfs(map, n, m, h, w, sRow, sCol, eRow, eCol);
		
		return answer;
	}
	
	private static int bfs(int[][] map, int n, int m, int h, int w, int sRow, int sCol, int eRow, int eCol) {
		Queue<Square> que = new PriorityQueue<>();
		boolean[][] visit = new boolean[n][m];
		visit[sRow - 1][sCol - 1] = true;
		que.offer(new Square(sCol - 1, sRow - 1, 0));
		while(!que.isEmpty()) {
			Square s = que.poll();
			if(s.isGoal(eRow, eCol)) {
				return s.dis;
			}
			for(int i=0;i<4;++i) {
				int nx = s.x + dx[i];
				int ny = s.y + dy[i];
				if(
					isRange(nx, ny, n, m) &&
					isRange(nx + w - 1, ny, n, m) &&
					isRange(nx, ny + h - 1, n, m) &&
					isRange(nx + w - 1, ny + h - 1, n, m) &&
					!visit[ny][nx] &&
					isCanGo(map, nx, ny, i, h, w) 
					) {
					visit[ny][nx] = true;
					que.offer(new Square(nx, ny, s.dis + 1));
				}
			}
		}
		return -1;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

	private static boolean isCanGo(int[][] map, int nx, int ny, int way, int h, int w) {
		boolean result = false;
		switch(way) {
		case 0:
			result = checkLeft(map, nx, ny, h, w);
			break;
		case 1:
			result = checkRight(map, nx, ny, h, w);
			break;
		case 2:
			result = checkUp(map, nx, ny, h, w);
			break;
		case 3:
			result = checkBottom(map, nx, ny, h, w);
			break;
		}
		return result;
	}

	private static boolean checkLeft(int[][] map, int nx, int ny, int h, int w) {
		for(int i=ny;i< ny+h;++i) {
			if(map[i][nx] == 1) {
				return false;
			}
		}
		return true;
	}
	private static boolean checkRight(int[][] map, int nx, int ny, int h, int w) {
		for(int i=ny;i< ny+h;++i) {
			if(map[i][nx + w - 1] == 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkUp(int[][] map, int nx, int ny, int h, int w) {
		for(int i=nx;i < nx+w;++i) {
			if(map[ny][i] == 1) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkBottom(int[][] map, int nx, int ny, int h, int w) {
		for(int i=nx;i < nx+w;++i) {
			if(map[ny + h - 1][i] == 1) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		tokens = new StringTokenizer(reader.readLine());
		int h = Integer.parseInt(tokens.nextToken());
		int w = Integer.parseInt(tokens.nextToken());
		int sRow = Integer.parseInt(tokens.nextToken());
		int sCol = Integer.parseInt(tokens.nextToken());
		int eRow = Integer.parseInt(tokens.nextToken());
		int eCol = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(map, n, m, h, w, sRow, sCol, eRow, eCol));
	}
}
