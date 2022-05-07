package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ≈‰∏∂≈‰2 {
	static class Tomato{
		int x;
		int y;
		int z;
		public Tomato(int x,int y,int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	private static final int NON_RIPE = 0;
	private static final int RIPE = 1;
	private static boolean[][][] visit;
	private static int[] dx = {-1,1,0,0,0,0};
	private static int[] dy = {0,0,-1,1,0,0};
	private static int[] dz = {0,0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		int h = Integer.parseInt(tokens.nextToken());
		int[][][] map = new int[h][n][m];
		for(int k=0;k<h;++k) {
			for(int i=0;i<n;++i) {
				tokens = new StringTokenizer(reader.readLine());
				for(int j=0;j<m;++j) {
					map[k][i][j] = Integer.parseInt(tokens.nextToken());
				}	
			}	
		}
		System.out.println(solution(map, n, m, h));
	}

	private static int solution(int[][][] map, int n, int m, int h) {
		int answer = 0;
		visit = new boolean[h][n][m];
		
		List<Tomato> findTomato = getTomatoes(map, n, m, h);
		if(findTomato.isEmpty()) {
			return -1;
		}else if(isAllRipe(map, n, m, h)) {
			return 0;
		}
		while(!findTomato.isEmpty()) {
			findTomato = splitTomato(findTomato, map, n, m, h);
			if(findTomato.isEmpty()) {
				break;
			}
			answer++;
		}
		if(canNotAllRipeTomato(map, n, m, h)) {
			return -1;
		}
		return answer;
	}


	private static List<Tomato> getTomatoes(int[][][] map, int n, int m, int h) {
		List<Tomato> tomatoes = new ArrayList<>();
		for(int k=0;k<h;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<m;++j) {
					if(isRipeTomato(map[k][i][j])) {
						tomatoes.add(new Tomato(j, i, k));
						visit[k][i][j] = true;
					}
				}	
			}	
		}
		return tomatoes;
	}

	private static boolean isRipeTomato(int tomato) {
		return tomato == RIPE;
	}
	
	private static boolean isAllRipe(int[][][] map, int n, int m, int h) {
		for(int k=0;k<h;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<m;++j) {
					if(isNonRipeTomato(map[k][i][j])) {
						return false;
					}
				}	
			}
		}
		return true;
	}

	private static boolean isNonRipeTomato(int tomato) {
		return tomato == NON_RIPE;
	}
	
	private static List<Tomato> splitTomato(List<Tomato> findTomato, int[][][] map, int n, int m, int h) {
		List<Tomato> tomatoes = new ArrayList<>();
		for(Tomato tomato : findTomato) {
			for(int i=0;i<6;++i) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
				int nz = tomato.z + dz[i];
				if(isRange(nx, ny, nz, n, m, h) && !visit[nz][ny][nx] && isNonRipeTomato(map[nz][ny][nx])) {
					visit[nz][ny][nx] = true;
					tomatoes.add(new Tomato(nx, ny, nz));
					map[nz][ny][nx] = RIPE;
				}
			}
		}
		return tomatoes;
	}

	private static boolean isRange(int nx, int ny, int nz, int n, int m, int h) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n && 0 <= nz && nz < h;
	}

	private static boolean canNotAllRipeTomato(int[][][] map, int n, int m, int h) {
		for(int k=0;k<h;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<m;++j) {
					if(isNonRipeTomato(map[k][i][j])) {
						return true;
					}
				}	
			}
		}
		return false;
	}
}
