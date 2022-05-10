package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class 공주님을구해라 {
	
	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};
	private static final int BLANK = 0;
	private static final int WEAPON = 2;
	private static boolean[][] visit;
	static class Princess implements Comparable<Princess>{
		int x;
		int y;
		int dis;
		public Princess(int x, int y, int dis) {
			this.dis = dis;
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Princess o) {
			return this.dis - o.dis;
		}
		public boolean isGoal(int n, int m) {
			return this.x == m-1 && this.y == n-1;
		}
		public boolean isWeapon(int[][] map) {
			return map[this.y][this.x] == WEAPON;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map, n, m, k));
	}
	private static String solution(int[][] map, int n, int m, int k) {
		StringBuilder answer = new StringBuilder();
		visit = new boolean[n][m];
		int findPrincessDistance = findPrincess(map, n, m, k);
		int findWeaponToPrincessDistance = findStartToWeapon(map, n, m, k);
		if(findPrincessDistance > k && findWeaponToPrincessDistance > k) {
			return "Fail";
		}
		int smallTime = Math.min(findPrincessDistance, findWeaponToPrincessDistance);
		answer.append(smallTime);
		return answer.toString();
	}
	
	private static int findPrincess(int[][] map, int n, int m, int k) {
		Queue<Princess> que = new PriorityQueue<>();
		visit = new boolean[n][m];
		visit[0][0] = true;
		que.offer(new Princess(0, 0, 0));
		while(!que.isEmpty()) {
			Princess princess = que.poll();
			if(princess.isGoal(n, m)) {
				return princess.dis;
			}
			for(int i=0;i<4;++i) {
				int nx = princess.x + dx[i];
				int ny = princess.y + dy[i];
				if(isRange(nx, ny,  n, m) && isBlank(map[ny][nx]) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					que.offer(new Princess(nx, ny, princess.dis + 1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	
	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
	private static boolean isBlank(int next) {
		return next == BLANK;
	}
	
	private static int findStartToWeapon(int[][] map, int n, int m, int k) {
		Queue<Princess> que = new PriorityQueue<>();
		visit = new boolean[n][m];
		visit[0][0] = true;
		que.offer(new Princess(0, 0, 0));
		boolean findWeapon = false;
		Princess weapon = null;
		while(!que.isEmpty()) {
			Princess princess = que.poll();
			if(princess.isWeapon(map)) {
				findWeapon = true;
				weapon = new Princess(princess.x, princess.y, princess.dis);
				break;
			}
			for(int i=0;i<4;++i) {
				int nx = princess.x + dx[i];
				int ny = princess.y + dy[i];
				if(isRange(nx, ny,  n, m) && isBlankOrWeapon(map[ny][nx]) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					que.offer(new Princess(nx, ny, princess.dis + 1));
				}
			}
		}
		if(isNotFoundWeapon(findWeapon, weapon)) {
			return Integer.MAX_VALUE;
		}
		int result = findWeaponToPrincess(map, n, m, k, weapon);
		return result;
	}
	
	private static boolean isBlankOrWeapon(int next) {
		return next == WEAPON || next == BLANK;
	}
	private static boolean isNotFoundWeapon(boolean findWeapon, Princess weapon) {
		return !findWeapon || weapon == null;
	}
	
	private static int findWeaponToPrincess(int[][] map, int n, int m, int k, Princess weapon) {
		Queue<Princess> que = new PriorityQueue<>();
		visit = new boolean[n][m];
		visit[weapon.y][weapon.x] = true;
		que.offer(weapon);
		while(!que.isEmpty()) {
			Princess princess = que.poll();
			if(princess.isGoal(n, m)) {
				return princess.dis;
			}
			for(int i=0;i<4;++i) {
				int nx = princess.x + dx[i];
				int ny = princess.y + dy[i];
				if(isRange(nx, ny,  n, m) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					que.offer(new Princess(nx, ny, princess.dis + 1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	
}
