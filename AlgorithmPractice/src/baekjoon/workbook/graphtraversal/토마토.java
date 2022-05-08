package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ≈‰∏∂≈‰ {
	private static final int RIPE = 1;
	private static final int[] dx = {-1,1,0,0};
	private static final int[] dy = {0,0,-1,1};
	private static final int NON_RIPE = 0;
	static class Tomato{
		int x;
		int y;
		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(int[][] map, int n, int m) {
		int answer = 0;
		visit = new boolean[n][m];
		List<Tomato> findTomato = getTomatoes(map, n, m);
		if(findTomato.isEmpty()) {
			return -1;
		}else if(isAllRipe(map, n, m)) {
			return 0;
		}
		while(true) {
			findTomato = findTomato(findTomato, map, n, m);
			if(findTomato.isEmpty()) {
				break;
			}
			answer++;
		}
		if(isNotAllRipeTomato(map, n, m)) {
			return -1;
		}
		
		
		return answer;
	}


	private static List<Tomato> getTomatoes(int[][] map, int n, int m) {
		List<Tomato> list = new ArrayList<>();
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(isRipeTomato(map[i][j])) {
					list.add(new Tomato(j, i));
					visit[i][j] = true;
				}
			}	
		}
		return list;
	}
	private static boolean isAllRipe(int[][] map, int n, int m) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(isNonRipeTomato(map[i][j])) {
					return false;
				}
			}	
		}
		return true;
	}
	private static boolean isRipeTomato(int tomato) {
		return tomato == RIPE;
	}

	private static List<Tomato> findTomato(List<Tomato> findTomato, int[][] map, int n, int m) {
		List<Tomato> newFindTomatoes = new ArrayList<>();
		for(Tomato tomato : findTomato) {
			for(int i=0;i<4;++i) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
				if(isRange(nx, ny, n, m) && !visit[ny][nx] && isNonRipeTomato(map[ny][nx])) {
					visit[ny][nx] = true;
					newFindTomatoes.add(new Tomato(nx, ny));
					map[ny][nx] = RIPE;
				}
			}
		}
		return newFindTomatoes;
	}

	private static boolean isNonRipeTomato(int tomato) {
		return tomato == NON_RIPE;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

	private static boolean isNotAllRipeTomato(int[][] map, int n, int m) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(isNonRipeTomato(map[i][j])) {
					return true;
				}
			}	
		}
		return false;
	}
}
