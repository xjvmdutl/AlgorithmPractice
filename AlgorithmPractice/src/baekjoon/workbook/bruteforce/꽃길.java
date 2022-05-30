package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ²É±æ {
	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};
	private static int answer;
	private static int sum;
	static class Flower{
		int x;
		int y;
		public Flower(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			Flower f = (Flower) obj;
			return f.x == this.x && f.y == this.y;
		}
		@Override
		public int hashCode() {
			return (10 * x) + y;
		}
	}
	
	private static int solution(int[][] map, int n) {
		answer = Integer.MAX_VALUE;
		boolean[][] visit = new boolean[n][n];
		permutation(map, visit, n, 0, 3, new Flower[3]);
		return answer;
	}
	private static void permutation(int[][] map, boolean[][] visit, int n, int count, int length, Flower[] flowers) {
		if(count == length) {
			Set<Flower> set = new HashSet<>();
			sum = 0;
			for(int i=0;i<3;++i) {
				Flower flower = flowers[i];
				if(isContains(set, flower)) {
					return;
				}
				set.add(flower);
				sum += map[flower.y][flower.x];
				if(!isOkay(map, set, flower, n)) {
					return;
				}
				
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(!visit[i][j]) {
					visit[i][j] = true;
					flowers[count] = new Flower(j, i);
					permutation(map, visit, n, count + 1, length, flowers);
					visit[i][j] = false;
				}
			}	
		}
	}
	private static boolean isContains(Set<Flower> set, Flower flower) {
		if(set.contains(flower)) {
			return true;
		}
		return false;
	}
	private static boolean isOkay(int[][] map, Set<Flower> set, Flower flower, int n) {
		for(int i=0;i<4;++i) {
			int nx = flower.x + dx[i];
			int ny = flower.y + dy[i];
			if(!isRange(nx, ny, n)) {
				return false;
			}
			Flower tmpFlower = new Flower(nx, ny);
			if(set.contains(tmpFlower)) {
				return false;
			}
			set.add(tmpFlower);
			sum += map[tmpFlower.y][tmpFlower.x];
		}
		return true;
	}
	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n));
	}

	
}
