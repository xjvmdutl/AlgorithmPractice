package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Unit implements Comparable<Unit>{
	int x;
	int y;
	int count;
	public Unit(int x, int y, int count) {
		this.count = count;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Unit o) {
		return this.count - o.count;
	}
}
public class 유닛이동시키기 {
	public static boolean[][] visit;
	public static int answer = 0;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = { 0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int a = Integer.parseInt(tokens.nextToken()) - 1;
		int b = Integer.parseInt(tokens.nextToken()) - 1;
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(tokens.nextToken()) - 1;
			int x = Integer.parseInt(tokens.nextToken()) - 1;
			map[y][x] = 1;
		}
		tokens = new StringTokenizer(reader.readLine());
		int startY = Integer.parseInt(tokens.nextToken()) - 1;
		int startX = Integer.parseInt(tokens.nextToken()) - 1;
		tokens = new StringTokenizer(reader.readLine());
		int endY = Integer.parseInt(tokens.nextToken()) - 1;
		int endX = Integer.parseInt(tokens.nextToken()) - 1;
		System.out.println(solution(map, a, b, startX, startY, endX, endY, n, m, k));
	}

	private static int solution(int[][] map, int a, int b, int startX, int startY, int endX, int endY, int n, int m,
			int k) {
		visit = new boolean[n][m];
		answer = -1;
		bfs(map, a, b, new Unit(startX, startY, 0), new Unit(endX, endY, 0),n, m);
		return answer;
	}

	private static void bfs(int[][] map, int a, int b, Unit start, Unit end, int n, int m) {
		Queue<Unit> pq = new PriorityQueue<>();
		pq.offer(start);
		visit[start.y][start.x] = true; 
		while(!pq.isEmpty()) {
			Unit u = pq.poll();
			if(isComplate(u, end)) {
				answer = u.count;
				return;
			}
			for(int i=0;i<4;++i) {
				int nx = u.x + dx[i];
				int ny = u.y + dy[i];
				if(isOkay(nx, ny, n, m, a, b) && !visit[ny][nx] && isNotBlock(map, nx, ny, a, b, i)) {
					visit[ny][nx] = true;
					pq.offer(new Unit(nx, ny, u.count+1));
				}
			}
		}
	}

	private static boolean isNotBlock(int[][] map, int nx, int ny, int a, int b, int dir) {
		if(dir == 0) {
			//왼쪽
			for(int i=0;i<=a;++i) {
				if(map[ny + i][nx] == 1) {
					return false;
				}
			}
		}else if( dir == 1) {
			//오른쪽
			for(int i=0;i<=a;++i) {
				if(map[ny + i][nx + b] == 1) {
					return false;
				}
			}
		}else if( dir == 2) {
			//위
			for(int i=0;i<=b;++i) {
				if(map[ny][nx + i] == 1) {
					return false;
				}
			}
		}else if( dir == 3){
			//아래
			for(int i=0;i<=b;++i) {
				if(map[ny + a][nx + i] == 1) {
					return false;
				}
			}	
		}
		return true;
	}

	private static boolean isOkay(int nx, int ny, int n, int m, int a, int b) {
		//사각형 끝점
		Unit[] unit = new Unit[4];
		unit[0] = new Unit(nx, ny, 0);
		unit[1] = new Unit(nx + b, ny, 0);
		unit[2] = new Unit(nx, ny + a, 0);
		unit[3] = new Unit(nx + b, ny + a, 0);
		for(int i=0;i<4; ++i) {
			if(!isRange(unit[i].x, unit[i].y, n, m)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx & nx < m && 0 <= ny && ny < n;
	}

	private static boolean isComplate(Unit u, Unit end) {
		return u.x == end.x && u.y == end.y;
	}

}
