package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 일루미네이션 {
	private static boolean[][] visit;
	private static int[] moveEvenX = {-1, -1, 0, 1, 0, -1};
	private static int[] moveEvenY = {0, -1, -1, 0, 1, 1};
	private static int[] moveOddX = {-1, 0, 1, 1, 1, 0};
	private static int[] moveOddY = {0, -1, -1, 0, 1, 1};
	static class Illumilation{
		private int x;
		private int y;
		public Illumilation(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int w = Integer.parseInt(tokens.nextToken());
		int h = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[h+2][w+2];
		for(int i=1;i<=h;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=1;j<=w;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map, w, h));
	}

	private static int solution(int[][] map, int w, int h) {
		visit = new boolean[h+2][w+2];
		findOuter(map, w, h);
		int answer = getResult(map, w, h);
		return answer;
	}

	private static void findOuter(int[][] map, int w, int h) {
		
		Queue<Illumilation> que = new LinkedList<>();
		que.offer(new Illumilation(0, 0));
		while(!que.isEmpty()) {
			Illumilation illumilation = que.poll();
			for(int i=0;i<6;++i) {
				if(isEven(illumilation.y)) {
					int nx = illumilation.x + moveEvenX[i];
					int ny = illumilation.y + moveEvenY[i];
					if(isRange(nx, ny, w, h) && !visit[ny][nx] && map[ny][nx] == 0) {
						visit[ny][nx] = true;
						que.offer(new Illumilation(nx, ny));
					}
				}else {
					int nx = illumilation.x + moveOddX[i];
					int ny = illumilation.y + moveOddY[i];
					if(isRange(nx, ny, w, h) && !visit[ny][nx] && map[ny][nx] == 0) {
						visit[ny][nx] = true;
						que.offer(new Illumilation(nx, ny));
					}
				}
			}
			
		}
		
	}

	private static boolean isEven(int y) {
		return y % 2 == 0;
	}

	private static boolean isRange(int nx, int ny, int w, int h) {
		return 0 <= nx && nx <= w+1 && 0 <= ny && ny <= h+1;
	}
	
	private static int getResult(int[][] map, int w, int h) {
		int answer = 0;
		for(int i=1;i<=h;++i) {
			for(int j=1;j<=w;++j) {
				if(map[i][j] == 0) {
					continue;
				}
				answer += getEllumilation(map, j, i, i);
			}	
		}
		
		return answer;
	}

	private static int getEllumilation(int[][] map, int x, int y, int row) {
		int count = 0;
		for(int i=0;i<6;++i) {
			if(isEven(row)) {
				int nx = x + moveEvenX[i];
				int ny = y + moveEvenY[i];
				if(visit[ny][nx]) {
					count++;
				}
			}else {
				int nx = x + moveOddX[i];
				int ny = y + moveOddY[i];
				if(visit[ny][nx]) {
					count++;
				}
			}
		}
		return count;
	}
}
