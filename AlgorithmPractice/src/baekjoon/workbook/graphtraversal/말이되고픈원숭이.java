package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¸»ÀÌµÇ°íÇÂ¿ø¼þÀÌ {
	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] horseDx = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static final int[] dy = {0, 0, -1, 1};
	private static final int[] horseDy = {-1, -2, -2, -1, 1, 2, 2, 1};
	private static final int BLANK = 0;
	static class Horse implements Comparable<Horse>{
		int x;
		int y;
		int count;
		int kCount;
		public Horse(int x, int y, int count, int kCount) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.kCount = kCount;
		}
		@Override
		public int compareTo(Horse o) {
			return this.count - o.count;
		}
		public boolean isGoal(int w, int h) {
			return this.x == w - 1 && this.y == h - 1;
		}
	}
	private static int solution(int[][] map, int w, int h, int k) {
		int answer = bfs(map, w, h, k);
		return answer;
	}
	
	private static int bfs(int[][] map, int w, int h, int k) {
		Queue<Horse> que = new PriorityQueue<>();
		boolean[][][] visit = new boolean[k + 1][h][w];
		que.offer(new Horse(0, 0, 0, 0));
		visit[0][0][0] = true;
		while(!que.isEmpty()) {
			Horse horse = que.poll();
			if(horse.isGoal(w, h)) {
				return horse.count;
			}
			
			for(int i=0;i < 4;++i) {
				int nx = horse.x + dx[i];
				int ny = horse.y + dy[i];
				if(isRange(nx, ny, w, h) && !visit[horse.kCount][ny][nx] && isBlank(map[ny][nx])) {
					visit[horse.kCount][ny][nx] = true;
					que.offer(new Horse(nx, ny, horse.count + 1, horse.kCount));
				}
			}
			if(!isOverToHorseJump(horse.kCount, k)) {
				for(int i=0;i<8;++i) {
					int nx = horse.x + horseDx[i];
					int ny = horse.y + horseDy[i];
					if(isRange(nx, ny, w, h) && !visit[horse.kCount + 1][ny][nx] && isBlank(map[ny][nx])) {
						que.offer(new Horse(nx, ny, horse.count + 1, horse.kCount + 1));
						visit[horse.kCount + 1][ny][nx] = true;
					}
				}
			}
		}
		return -1;
	}

	private static boolean isOverToHorseJump(int kCount, int k) {
		return kCount >= k;
	}
	
	private static boolean isRange(int nx, int ny, int w, int h) {
		return 0 <= nx && nx < w && 0 <= ny && ny < h;
	}
	
	private static boolean isBlank(int num) {
		return num == BLANK;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int w = Integer.parseInt(tokens.nextToken());
		int h = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[h][w];
		for(int i=0;i<h;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<w;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, w, h, k));
	}


}
