package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class 움직이는미로탈출 {
	private static final int ROW = 8;
	private static final int COL = 8;
	private static final int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	private static final int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	private static List<Wall> walls;
	static class Characters{
		int x;
		int y;
		public Characters(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			Characters c = (Characters) obj;
			return c.x == x && c.y == y;
		}
		@Override
		public int hashCode() {
			return 10 * x + y;
		}
	}
	static class Wall{
		int x;
		int y;
		public Wall(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[ROW][COL];
		for(int i=0;i <ROW;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map));
	}
	private static int solution(char[][] map) {
		int answer = bfs(map);
		return answer;
	}
	private static int bfs(char[][] map) {
		Queue<Characters> que = new LinkedList<>();
		walls = getWalls(map);
		que.offer(new Characters(0, ROW-1));
		while(true) {
			if(que.isEmpty()) {
				return 0;
			}
			if(walls.isEmpty() && !que.isEmpty()) {
				break;
			}
			int size = que.size();
			boolean[][] visit = new boolean[ROW][COL];
			for(int s = 0; s < size; ++s) {
				Characters c = que.poll();
				for(int i=0;i<9;++i) {
					int nx = c.x + dx[i];
					int ny = c.y + dy[i];
					if(isRange(nx, ny) && !visit[ny][nx] && isBlank(map[ny][nx])) {
						visit[ny][nx] = true;
						que.offer(new Characters(nx, ny));
					}
				}
			}
			fallWall(map, que, visit);
		}
		return 1;
	}
	private static void fallWall(char[][] map, Queue<Characters> que, boolean[][] visit) {
		List<Wall> resultWalls = new ArrayList<>();
		Collections.sort(walls, (o1, o2)->{
			return o2.y - o1.y;
		});
		for(Wall wall : walls) {
			int nx = wall.x;
			int ny = wall.y + 1;
			if(isRange(nx, ny)) {
				resultWalls.add(new Wall(nx, ny));
				if(visit[ny][nx]) {
					que.remove(new Characters(nx, ny));
				}
				map[ny][nx] = '#';
			}
			map[wall.y][wall.x] = '.';
		}
		walls = resultWalls;
	}
	private static boolean isRange(int nx, int ny) {
		return 0 <= nx && nx < COL && 0 <= ny && ny < ROW;
	}
	private static boolean isBlank(char c) {
		return c == '.';
	}
	private static List<Wall> getWalls(char[][] map) {
		List<Wall>  walls = new ArrayList<>();
		for(int i=0;i <ROW;++i) {
			for(int j=0;j<ROW;++j) {
				if(isWall(map[i][j])) {
					walls.add(new Wall(j, i));
				}
			}
		}
		return walls;
	}
	private static boolean isWall(char c) {
		return c == '#';
	}

}
