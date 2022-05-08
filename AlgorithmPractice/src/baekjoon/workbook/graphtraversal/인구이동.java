package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {
	private static final int[] dx = {-1,1,0,0};
	private static final int[] dy = {0,0,-1,1};
	private static List<List<Country>> openCountries;
	static class Country{
		int x;
		int y;
		public Country(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int l = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map, n, l, r));
	}

	private static int solution(int[][] map, int n, int l, int r) {
		int answer = 0;
		while(true) {
			boolean[][] openCountry = new boolean[n][n];
			openCountries = new ArrayList<>();
			findOpenCountry(map, openCountry, n, l, r);
			if(openCountries.isEmpty()) {
				break;
			}
			answer++;
			moveToContry(map, n);
		}
		return answer;
	}

	

	private static void findOpenCountry(int[][] map, boolean[][] openCountry, int n, int l, int r) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(!openCountry[i][j]) {
					openCountry[i][j] = true;
					openCountry(map, openCountry, n, l, r, j, i);
				}
			}	
		}
	}

	private static void openCountry(int[][] map, boolean[][] openCountry, int n, int l, int r, int x, int y) {
		List<Country> coutries = new ArrayList<>();
		Queue<Country> que = new LinkedList<>();
		que.offer(new Country(x, y));
		while(!que.isEmpty()) {
			Country country = que.poll();
			coutries.add(country);
			for(int i=0;i<4;++i) {
				int nx = country.x + dx[i];
				int ny = country.y + dy[i];
				if(isRange(nx, ny, n) && !openCountry[ny][nx] && isDiffIn(map[ny][nx], map[country.y][country.x], l, r)) {
					openCountry[ny][nx] = true;
					que.offer(new Country(nx, ny));
				}
			}
		}
		if(coutries.size() <= 1) {
			return;
		}
		openCountries.add(coutries);
		
		
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

	private static boolean isDiffIn(int coutry1, int country2, int l, int r) {
		int diff = Math.abs(coutry1-country2);
		return l <= diff && diff <= r;
	}
	
	private static void moveToContry(int[][] map, int n) {
		for(List<Country> coutries : openCountries) {
			int avg = (int)coutries.stream().mapToInt((o) -> map[o.y][o.x]).average().getAsDouble();
			for(Country country : coutries) {
				map[country.y][country.x] = avg; 
			}
		}
	}

}
