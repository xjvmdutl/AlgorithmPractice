package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ¿À¸ñ {
	private static final int N = 19;
	private static final int BLANK = 0;
	private static final int BLACK = 1;
	private static final int WHITE = 2;
	private static List<Ball> list;
	static class Ball{
		int x;
		int y;
		public Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static String solution(int[][] map) {
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				boolean isFind = find(map, j, i);
				if(isFind) {
					if(isBlack(map[i][j])) {
						answer.append(BLACK + "\n");
					}else {
						answer.append(WHITE + "\n");
					}
					Collections.sort(list, (o1, o2) -> {
						if(o1.x == o2.x) {
							return o1.y - o2.y;
						}
						return o1.x - o2.x;
					});
					answer.append((list.get(0).y + 1) + " " + (list.get(0).x + 1));
					return answer.toString();
				}
			}	
		}
		answer.append(0);
		return answer.toString();
	}
	
	private static boolean find(int[][] map, int x, int y) {
		if(isBlank(map[y][x])) {
			return false;
		}else if( findRow(map, x, y) || findCol(map, x, y) || findUpDiagonal(map, x, y) || findDownDiagonal(map, x, y)) {
			return true;
		}
		return false;
	}

	private static boolean isBlank(int data) {
		return data == BLANK;
	}

	private static boolean findRow(int[][] map, int x, int y) {
		list = new ArrayList<>();
		list.add(new Ball(x, y));
		for(int i = 1; i < N; ++i) {
			int nx = x - i;
			int ny = y;
			if(!isRange(nx, ny) || !isSame(map[ny][nx], map[y][x])) {
				break;
			}
			list.add(new Ball(nx, ny));
		}
		for(int i = 1; i < N; ++i) {
			int nx = x + i;
			int ny = y;
			if(!isRange(nx, ny) || !isSame(map[ny][nx], map[y][x])) {
				break;
			}
			list.add(new Ball(nx, ny));
		}
		return list.size() == 5;
	}
	
	private static boolean findCol(int[][] map, int x, int y) {
		list = new ArrayList<>();
		list.add(new Ball(x, y));
		for(int i = 1; i < N; ++i) {
			int nx = x;
			int ny = y - i;
			if(!isRange(nx, ny) || !isSame(map[ny][nx], map[y][x])) {
				break;
			}
			list.add(new Ball(nx, ny));
		}
		for(int i = 1; i < N; ++i) {
			int nx = x;
			int ny = y + i;
			if(!isRange(nx, ny) || !isSame(map[ny][nx], map[y][x])) {
				break;
			}
			list.add(new Ball(nx, ny));
		}
		return list.size() == 5;
	}
	
	private static boolean findUpDiagonal(int[][] map, int x, int y) {
		list = new ArrayList<>();
		list.add(new Ball(x, y));
		for(int i = 1; i < N; ++i) {
			int nx = x - i;
			int ny = y + i;
			if(!isRange(nx, ny) || !isSame(map[ny][nx], map[y][x])) {
				break;
			}
			list.add(new Ball(nx, ny));
		}
		for(int i = 1; i < N; ++i) {
			int nx = x + i;
			int ny = y - i;
			if(!isRange(nx, ny) || !isSame(map[ny][nx], map[y][x])) {
				break;
			}
			list.add(new Ball(nx, ny));
		}
		return list.size() == 5;
	}
	
	private static boolean findDownDiagonal(int[][] map, int x, int y) {
		list = new ArrayList<>();
		list.add(new Ball(x, y));
		for(int i = 1; i < N; ++i) {
			int nx = x - i;
			int ny = y - i;
			if(!isRange(nx, ny) || !isSame(map[ny][nx], map[y][x])) {
				break;
			}
			list.add(new Ball(nx, ny));
		}
		for(int i = 1; i < N; ++i) {
			int nx = x + i;
			int ny = y + i;
			if(!isRange(nx, ny) || !isSame(map[ny][nx], map[y][x])) {
				break;
			}
			list.add(new Ball(nx, ny));
		}
		return list.size() == 5;
	}
	
	private static boolean isRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
	private static boolean isSame(int data, int diff) {
		return data == diff;
	}
	
	private static boolean isBlack(int data) {
		return data == BLACK;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[N][N];
		for(int i=0; i<N; ++i) {
			StringTokenizer tokens= new StringTokenizer(reader.readLine());
			for(int j=0; j<N; ++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map));
	}
	
}
