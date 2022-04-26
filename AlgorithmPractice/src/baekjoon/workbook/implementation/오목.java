package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¿À¸ñ {
	private static final int FIVE = 5;
	private static final int SIZE = 19;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[SIZE][SIZE];
		for(int i=0;i<SIZE;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<SIZE;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map));
	}
	private static String solution(int[][] map) {
		StringBuilder answer = new StringBuilder();
		find(map, answer);
		return answer.toString();
	}
	private static void find(int[][] map, StringBuilder answer) {
		for(int i=0;i<SIZE;++i) {
			for(int j=0;j<SIZE;++j) {
				if((isBlack(map[i][j]) || isWhite(map[i][j])) && check(map, i, j, answer)) {
					return;
				}
			}	
		}
		answer.append(0);
	}
	
	private static boolean isBlack(int num) {
		return num == 1;
	}
	
	private static boolean isWhite(int num) {
		return num == 2;
	}

	private static boolean check(int[][] map, int y, int x, StringBuilder answer) {
		if(isRowCheck(map, x, y)) {
			answer.append(map[y][x] + "\n");
			answer.append(findFirstRow(map, x, y));
			return true;
		}else if(isColCheck(map, x, y)) {
			answer.append(map[y][x] + "\n");
			answer.append(findFirstCol(map, x, y));
			return true;
		}else if(isUpColDownRowCheck(map, x, y)) {
			answer.append(map[y][x] + "\n");
			answer.append(findFirstUpColDownRow(map, x, y));
			return true;
		}else if(isDownColUpRowCheck(map, x, y)) {
			answer.append(map[y][x] + "\n");
			answer.append(findFirstUpRowDownCol(map, x, y));
			return true;
		}
		return false;
	}
	private static String findFirstUpRowDownCol(int[][] map, int x, int y) {
		int now = map[y][x];
		int minX = x;
		int minY = y;
		for(int i=1;i<SIZE;++i) {
			if(isRange(y + i, x - i) && isSame(now, map[y + i][x - i])) {
				minX = x - i;
				minY = y + i;
				continue;
			}
			break;
		}
		
		return (minY + 1) + " " + (minX + 1);
	}
	private static String findFirstUpColDownRow(int[][] map, int x, int y) {
		int now = map[y][x];
		int minX = x;
		int minY = y;
		for(int i=1;i<SIZE;++i) {
			if(isRange(y - i, x - i) && isSame(now, map[y - i][x - i])) {
				minX = x - i;
				minY = y - i;
				continue;
			}
			break;
		}
		
		return (minY + 1) + " " + (minX + 1);
	}
	private static String findFirstRow(int[][] map, int x, int y) {
		int now = map[y][x];
		int min = y;
		for(int i=y;i>=0;--i) {
			if(isSame(now, map[y][i])) {
				min = i;
				continue;
			}
			break;
		}
		return (min + 1) + " " + (x + 1);
	}
	private static String findFirstCol(int[][] map, int x, int y) {
		int now = map[y][x];
		int min = x;
		for(int i=x-1;i>=0;--i) {
			if(isSame(now, map[y][i])) {
				min = i;
				continue;
			}
			break;
		}
		return (y + 1) + " " + (min + 1);
	}
	private static boolean isColCheck(int[][] map, int x, int y) {
		int now = map[y][x];
		int count = 1;
		for(int i=x+1;i<SIZE;++i) {
			if(isSame(now, map[y][i])) {
				count++;
				continue;
			}
			break;
		}
		for(int i=x-1;i>=0;--i) {
			if(isSame(now, map[y][i])) {
				count++;
				continue;
			}
			break;
		}
		return isFive(count);
	}
	
	private static boolean isRowCheck(int[][] map, int x, int y) {
		int now = map[y][x];
		int count = 1;
		for(int i=y+1;i<SIZE;++i) {
			if(isSame(now, map[i][x])) {
				count++;
				continue;
			}
			break;
		}
		for(int i=y-1;i>=0;--i) {
			if(isSame(now, map[i][x])) {
				count++;
				continue;
			}
			break;
		}
		return isFive(count);
	}
	
	private static boolean isDownColUpRowCheck(int[][] map, int x, int y) {
		int now = map[y][x];
		int count = 1;
		for(int i=1;i<SIZE;++i) {
			if(isRange(y - i, x + i) && isSame(now, map[y - i][x + i])) {
				count++;
				continue;
			}
			break;
		}
		for(int i=1;i<SIZE;++i) {
			if(isRange(y + i, x - i) && isSame(now, map[y + i][x - i])) {
				count++;
				continue;
			}
			break;
		}
		
		return isFive(count);
	}
	
	private static boolean isUpColDownRowCheck(int[][] map, int x, int y) {
		int now = map[y][x];
		int count = 1;
		for(int i=1;i<SIZE;++i) {
			if(isRange(y + i, x + i) && isSame(now, map[y + i][x + i])) {
				count++;
				continue;
			}
			break;
		}
		for(int i=1;i<SIZE;++i) {
			if(isRange(y - i, x - i) && isSame(now, map[y - i][x - i])) {
				count++;
				continue;
			}
			break;
		}
		
		return isFive(count);
	}
	
	private static boolean isRange(int ny, int nx) {
		return 0 <= nx && nx < SIZE  && 0 <= ny && ny < SIZE;
	}
	private static boolean isFive(int count) {
		return count == FIVE;
	}
	private static boolean isSame(int now, int num) {
		return now == num;
	}
	
	
}
