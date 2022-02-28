package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Robot implements Comparable<Robot>{
	int x;
	int y;
	int dir;
	int count;
	public Robot(int x, int y, int dir, int count) {
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.count = count;
	}
	@Override
	public int compareTo(Robot o) {
		return this.count- o.count;
	}
}
public class 로봇 {
	public static int answer;
	public static boolean[][][] visit;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int[] turnLeft = {3, 2, 0, 1};
	public static int[] turnRight = {2, 3, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
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
		int startY = Integer.parseInt(tokens.nextToken()) - 1;
		int startX = Integer.parseInt(tokens.nextToken()) - 1;
		int startDir = Integer.parseInt(tokens.nextToken()) - 1;
		tokens = new StringTokenizer(reader.readLine());
		int endY = Integer.parseInt(tokens.nextToken()) - 1;
		int endX = Integer.parseInt(tokens.nextToken()) - 1;
		int endDir = Integer.parseInt(tokens.nextToken()) - 1;
		System.out.println(solution(map, n, m, new Robot(startX, startY, startDir, 0), new Robot(endX, endY, endDir, 0)));
	}

	private static int solution(int[][] map, int n, int m, Robot start, Robot end) {
		answer = 0;
		visit = new boolean[n][m][4];
		bfs(map, n, m, start, end);
		return answer;
	}

	private static void bfs(int[][] map, int n, int m, Robot start, Robot end) {
		Queue<Robot> pq = new PriorityQueue<>();
		pq.offer(new Robot(start.x, start.y, start.dir, 0));
		visit[start.y][start.x][start.dir] = true;
		while(!pq.isEmpty()) {
			Robot r = pq.poll();
			if(r.dir == end.dir && r.x == end.x && r.y == end.y) {
				answer = r.count;
				return;
			}
			//직진
			for(int i=1;i<=3;++i) {
				int nx = r.x + (dx[r.dir]*i);
				int ny = r.y + (dy[r.dir]*i);
				if(isRange(nx, ny, n ,m)) {
					if(map[ny][nx] == 1)
						break;
					if(!visit[ny][nx][r.dir]) {
						visit[ny][nx][r.dir] = true;
						pq.offer(new Robot(nx, ny, r.dir, r.count + 1));
					}
				}
			}
			// 왼쪽 회전
			int leftTurn = turnLeft[r.dir];
			if(!visit[r.y][r.x][leftTurn]) {
				visit[r.y][r.x][leftTurn] = true;
				pq.offer(new Robot(r.x, r.y, leftTurn, r.count+1));
			}
			//오른쪽 회전
			int rightTurn = turnRight[r.dir];
			if(!visit[r.y][r.x][rightTurn]) {
				visit[r.y][r.x][rightTurn] = true;
				pq.offer(new Robot(r.x, r.y, rightTurn, r.count+1));
			}
			
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
}
