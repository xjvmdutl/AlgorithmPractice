package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {
	private static final int[] dx = {-1,1,0,0};
	private static final int[] dy = {0,0,-1,1};
	private static final int GOAL = 2;
	private static final int GO = 1;
	private static final int WALL = 0;
	static class Goal implements Comparable<Goal>{
		int x;
		int y;
		int dis;
		public Goal(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		@Override
		public int compareTo(Goal o) {
			return this.dis - o.dis;
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

	private static String solution(int[][] map, int n, int m) {
		int[][] result = goToGoal(map, n, m);
		return printResult(result);
	}


	private static int[][] goToGoal(int[][] map, int n, int m) {
		Queue<Goal> que = new PriorityQueue<>();
		int[][] visit = init(map, n, m);
		Goal goal = findGoal(map, n, m);
		visit[goal.y][goal.x] = 0;
		que.offer(goal);
		while(!que.isEmpty()) {
			Goal g = que.poll();
			for(int i=0;i<4;++i) {
				int nx = g.x + dx[i];
				int ny = g.y + dy[i];
				if(isRange(nx, ny, n, m) && isLeast(g.dis+1, visit[ny][nx]) && isGoTo(map[ny][nx])) {
					visit[ny][nx] = g.dis + 1;
					que.offer(new Goal(nx, ny, g.dis + 1));
				}
			}
		}
		
		return visit;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

	private static boolean isLeast(int num, int diff) {
		return num < diff;
	}

	private static boolean isGoTo(int num) {
		return num == GO;
	}

	private static int[][] init(int[][] map, int n, int m) {
		int[][] result = new int[n][m];
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(isGoTo(map[i][j])) {
					result[i][j] = Integer.MAX_VALUE;
				}
			}	
		}
		return result;
	}

	private static Goal findGoal(int[][] map, int n, int m) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(isGoal(map[i][j])) {
					return new Goal(j, i, 0);
				}
			}	
		}
		throw new IllegalArgumentException();
	}

	private static boolean isGoal(int data) {
		return data == GOAL;
	}

	private static String printResult(int[][] result) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<result.length;++i) {
			for(int j=0;j<result[i].length;++j) {
				if(isCannotGoTo(result[i][j])){
					answer.append(-1 + " ");	
				}else if(isBlank(result[i][j])) {
					answer.append(WALL + " ");					
				}else {
					answer.append(result[i][j] + " ");	
				}
			}
			answer.append("\n");
		}
		return answer.toString();
	}

	private static boolean isCannotGoTo(int num) {
		return num == Integer.MAX_VALUE;
	}

	private static boolean isBlank(int num) {
		return num == WALL;
	}
}
