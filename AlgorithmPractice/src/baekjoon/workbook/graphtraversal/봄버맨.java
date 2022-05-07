package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class º½¹ö¸Ç {
	private static final int START_BOMB_TIME = 3;
	private static final int BOMB_TIME = 0;
	private static final int[] dx = {-1,1,0,0};
	private static final int[] dy = {0,0,-1,1};
	static class Bomb{
		int x;
		int y;
		public Bomb(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[r][c];
		for(int i=0;i<r;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map, r, c, n));
	}

	private static String solution(char[][] map, int r, int c, int n) {
		int[][] visit = new int[r][c];
		startBomb(map, visit, r, c);
		stopBomb(map, visit, r, c);
		n--;
		boolean isFirst = true;
		while(n-- > 0) {
			bombCheck(visit, r, c);
			if(isFirst) {
				isFirst = false;
				createBombAll(visit, r, c);
			}else {

				isFirst = true;
			}			
		}
		return print(visit, r ,c);
	}
	

	

	private static void startBomb(char[][] map, int[][] visit, int r, int c) {
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(isBomb(map[i][j])) {
					visit[i][j] = START_BOMB_TIME;
				}
			}
		}
	}
	
	private static boolean isBomb(char c) {
		return c == 'O';
	}

	private static void stopBomb(char[][] map, int[][] visit, int r, int c) {
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(isBomb(map[i][j])) {
					visit[i][j]--;
				}
			}
		}
	}

	private static void bombCheck(int[][] visit, int r, int c) {
		List<Bomb> bombs = new ArrayList<>();
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(isBomb(visit[i][j])) {
					if(isFire(visit[i][j])) {
						bombs.add(new Bomb(j, i));
					}else {
						visit[i][j]--;
					}
				}
				
			}
		}
		fireBombs(bombs, visit, r, c);
	}
	
	

	private static boolean isBomb(int bomb) {
		return bomb > 0;
	}

	private static boolean isFire(int bomb) {
		return bomb - 1 == BOMB_TIME;
	}
	
	private static void fireBombs(List<Bomb> bombs, int[][] visit, int r, int c) {
		for(Bomb bomb : bombs) {
			fireBomb(visit, r, c, bomb);
		}
	}
	private static void fireBomb(int[][] visit, int r, int c, Bomb bomb ) {
		visit[bomb.y][bomb.x] = BOMB_TIME;
		for(int i=0;i<4;++i) {
			int nx = bomb.x + dx[i];
			int ny = bomb.y + dy[i];
			if(isRange(nx, ny, r, c)) {
				visit[ny][nx] = BOMB_TIME;
			}
		}
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny && ny < r;
	}

	

	private static void createBombAll(int[][] visit, int r, int c) {
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(isEmpty(visit[i][j])) {
					visit[i][j] = START_BOMB_TIME;
				}
			}
		}
	}

	private static boolean isEmpty(int bomb) {
		return bomb == BOMB_TIME;
	}
	
	private static String print(int[][] visit,int r, int c) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(isBombCheck(visit[i][j])) {
					answer.append(".");
				}else {
					answer.append("O");
				}
			}	
			answer.append("\n");
		}
		return answer.toString();
	}

	private static boolean isBombCheck(int bomb) {
		return bomb == BOMB_TIME;
	}
}
