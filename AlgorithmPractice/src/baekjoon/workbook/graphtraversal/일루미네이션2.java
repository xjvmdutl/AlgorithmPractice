package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 일루미네이션2 {
	public static final int[][] dx = {
			{-1, -1, 0, 1, 0, -1},
			{-1, 0, 1, 1, 1, 0}
	};
	public static final int[][] dy = {
			{0, -1, -1, 0, 1, 1},
			{0, -1, -1, 0, 1, 1}
	};
	private static final int BLANK = 0;
	public static boolean[][] visit;
	static class Illumilation{
		int x;
		int y;
		public Illumilation(int x, int y) {
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
		findOuterIllumilation(map, w, h);
		
		return getResult(map, w, h);
	}

	private static int getResult(int[][] map, int w, int h) {
		int answer = 0;
		for(int i=1;i<=h;++i) {
			for(int j=1;j<=w;++j) {
				if(isBlank(map[i][j])) {
					continue;
				}
				answer += getEdgeCount(j, i);
			}
		}
		return answer;
	}

	private static void findOuterIllumilation(int[][] map, int w, int h) {
		Queue<Illumilation> que = new LinkedList<>();
		que.offer(new Illumilation(0, 0));
		while(!que.isEmpty()) {
			Illumilation illumilation = que.poll();
			for(int i=0;i<6;++i) {
				int condition = illumilation.y % 2;
				int nx = illumilation.x + dx[condition][i];
				int ny = illumilation.y + dy[condition][i];
				if(isRange(nx, ny, w, h) && !visit[ny][nx] && isBlank(map[ny][nx])) {
					que.offer(new Illumilation(nx, ny));
					visit[ny][nx] = true;
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny, int w, int h) {
		return 0 <= nx && nx < w+2 && 0 <= ny && ny < h +2;
	}

	private static boolean isBlank(int map) {
		return map == BLANK;
	}
	
	private static int getEdgeCount(int x, int y) {
		int count = 0;
		for(int i=0;i<6;++i) {
			int condition = y % 2;
			int nx = x + dx[condition][i];
			int ny = y + dy[condition][i];
			if(visit[ny][nx]) {
				count++;
			}
		}
		return count;
	}
}
