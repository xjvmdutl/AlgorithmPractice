package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ДЎБо {
	private static boolean[][] visit;
	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = { 0, 0, -1, 1};
	private static final int BLANK = 0;
	private static final int CHEESE = 1;
	private static int lastCheeseCount = 0;
	static class Cheese{
		int x;
		int y;
		public Cheese(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	private static String solution(int[][] map, int n, int m) {
		StringBuilder answer = new StringBuilder();
		int day = 0;
		while(true) {
			visit = new boolean[n + 2][m + 2];
			boolean isStop = find(map, n, m);
			if(isStop) {
				break;
			}
			day++;
		}
		answer.append(day + "\n");
		answer.append(lastCheeseCount + "\n");
		return answer.toString();
	}
	
	private static boolean find(int[][] map, int n, int m) {
		List<Cheese> cheeses = new ArrayList<>();
		int count = getCheeseCount(map, n, m);
		bfs(map, cheeses, n, m, 0, 0);
		if(cheeses.isEmpty()) {
			return true;
		}
		lastCheeseCount = count;
		meltCheese(map, cheeses);
		return false;
	}


	private static int getCheeseCount(int[][] map, int n, int m) {
		int count = 0; 
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(isCheese(map[i][j]))
					count++;
			}
		}
		return count;
	}

	private static void bfs(int[][] map, List<Cheese> cheeses, int n, int m, int y, int x) {
		Queue<Cheese> que = new LinkedList<>();
		que.offer(new Cheese(x, y));
		visit[y][x] = true;
		while(!que.isEmpty()) {
			Cheese cheese = que.poll();
			for(int i=0;i<4;++i) {
				int nx = cheese.x + dx[i];
				int ny = cheese.y + dy[i];
				if(isRange(nx, ny, n, m) && !visit[ny][nx]) {
					if(isBlank(map[ny][nx])) {
						visit[ny][nx] = true;
						que.offer(new Cheese(nx, ny));
					}else if(isCheese(map[ny][nx])){
						visit[ny][nx] = true;
						cheeses.add(new Cheese(nx, ny));
					}
				}
			}
		}
	}
	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

	private static boolean isBlank(int map) {
		return map == BLANK;
	}

	private static boolean isCheese(int map) {
		return map == CHEESE;
	}

	private static void meltCheese(int[][] map, List<Cheese> cheeses) {
		for(Cheese cheese : cheeses) {
			map[cheese.y][cheese.x ] = BLANK; 
		}
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
		System.out.println(solution(map, n, m));
	}

}
