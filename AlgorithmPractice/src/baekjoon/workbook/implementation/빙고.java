package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 빙고 {
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			Point p = (Point)obj;
			return p.x == this.x && p.y == this.y;
		}
		@Override
		public int hashCode() {
			return super.hashCode();
		}
	}
	public static boolean[][] visit;
	private static final int SIZE = 5;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] bingo = Init(reader);
		int[][] moderator = Init(reader);
		System.out.println(solution(bingo, moderator));
	}

	private static int solution(int[][] bingo, int[][] moderator) {
		
		Map<Integer, Point> map = new HashMap<>();
		IndexMatching(map, bingo);
		visit = new boolean[SIZE][SIZE];
		int answer = 0;
		OUTER:for(int i=0;i<SIZE;++i) {
			for(int j=0;j<SIZE;++j) {
				answer++;
				if(isContains(map, moderator[i][j])) {
					Point now = map.get(moderator[i][j]);
					visit[now.y][now.x] = true;
					int count = coutingBingo();
					if(isBingoOkay(count)) {
						break OUTER;
					}
				}
			}	
		}
		return answer;
	}

	
	private static int coutingBingo() {
		int count = 0;
		//행 열 체크
		count += calcRowAndCol();
		//대각선 체크
		count += calcDiagonal();
		return count;
	}

	private static int calcDiagonal() {
		int upRowUpCol = 0;
		int upRowDownCol = 0;
		for(int i=0;i<SIZE;++i) {
			if(visit[i][i]) {
				upRowUpCol++;
			}
			if(visit[i][SIZE-i-1]) {
				upRowDownCol++;
			}
		}
		int count = 0;
		if(isPlusCount(upRowUpCol)) {
			count++;
		}
		if(isPlusCount(upRowDownCol)) {
			count++;
		}
		return count;
	}

	private static int calcRowAndCol() {
		int count = 0;
		for(int i=0;i<SIZE;++i) {
			int rowCount = 0;
			int colCount = 0;
			//행계산, 열계산
			for(int j=0;j<SIZE;++j) {
				if(visit[i][j])
					rowCount++;
				if(visit[j][i])
					colCount++;
			}
			if(isPlusCount(rowCount)) {
				count++;
			}
			if(isPlusCount(colCount)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isPlusCount(int count) {
		return count == SIZE;
	}

	private static boolean isBingoOkay(int count) {
		return count >= 3;
	}

	private static boolean isContains(Map<Integer, Point> map, int moderator) {
		return map.containsKey(moderator);
	}

	private static void IndexMatching(Map<Integer, Point> map, int[][] bingo) {
		for(int i=0;i<SIZE;++i) {
			for(int j=0;j<SIZE;++j) {
				map.put(bingo[i][j], new Point(j, i));
			}	
		}
	}
	private static int[][] Init(BufferedReader reader) throws IOException {
		int[][] map = new int[SIZE][SIZE];
		for(int i=0;i<SIZE;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<SIZE;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		return map;
	}
}
