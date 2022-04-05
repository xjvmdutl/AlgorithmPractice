package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Áö·ÚÃ£±â {
	static class Bomb{
		int x;
		int y;
		public Bomb(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[][] map = new char[n][n];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		char[][] findMap = new char[n][n];
		for(int i=0;i<n;++i) {
			findMap[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map, findMap, n));
	}

	private static String solution(char[][] map, char[][] findMap, int n) {
		boolean isFail = false;
		List<Bomb> bombs = new ArrayList<>();
		char[][] prints = new char[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(findMap[i][j] == 'x') {
					int count = findNext(map, j, i, n);
					prints[i][j] = (char) ('0' + count);
					if(map[i][j] == '*') {
						isFail = true;
					}
				}else if(findMap[i][j] == '.') {
					prints[i][j] = '.';
				}
				if(map[i][j] == '*') {
					bombs.add(new Bomb(j, i));
				}
			}	
		}
		StringBuilder sb = new StringBuilder();
		if(isFail){
			for(int i=0;i<bombs.size();++i) {
				Bomb bomb = bombs.get(i);
				prints[bomb.y][bomb.x] = '*';
			}
		}
		print(sb, prints, n);
		return sb.toString();
	}

	private static void print(StringBuilder sb, char[][] prints, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				sb.append(prints[i][j]);
			}	
			sb.append("\n");
		}
	}

	private static int findNext(char[][] map, int x, int y, int n) {
		int count = 0;
		for(int i=0;i<8;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx, ny, n) && map[ny][nx] == '*') {
				count++;
			}
		}
		return count;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
