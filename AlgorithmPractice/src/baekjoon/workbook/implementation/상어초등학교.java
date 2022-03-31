package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 상어초등학교 {
	
	static class Shark implements Comparable<Shark>{
		int x;
		int y;
		int love;
		int blank;
		public Shark(int x, int y, int love, int blank) {
			this.x = x;
			this.y = y;
			this.love = love;
			this.blank = blank;
		}
		@Override
		public int compareTo(Shark o) {
			if(o.love == this.love) {
				if(o.blank == this.blank) {
					if(o.y == this.y) {
						return this.x - o.x;
					}
					return this.y - o.y;
				}
				return o.blank - this.blank;
			}
			return o.love - this.love;
		}
		public void addBlank() {
			this.blank++;
		}
		public void addLove() {
			this.love++;
		} 
	}
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};

	private static int solution(int[][] arr, int n) {
		int[][] map = new int[n][n];
		for(int i=0;i<arr.length;++i) {
			bfs(map, n, arr[i]);
		}
		Arrays.sort(arr, (o1,o2)->o1[0] - o2[0]);
		return calcSum(map, n, arr);
	}

	private static int calcSum(int[][] map, int n, int[][] arr) {
		int sum = 0;
		for(int i=0;i<map.length;++i) {
			for(int j=0;j<map.length;++j) {
				int love = findScore(map, n, arr, j, i);
				sum += returnScore(love); 
			}	
		}
		return sum;
	}

	private static int findScore(int[][] map, int n, int[][] arr, int x, int y) {
		int love = 0;
		Set<Integer> loves = new HashSet<>();
		for(int i=0;i<4;++i) {
			loves.add(arr[map[y][x] - 1][i + 1]);
		}
		for(int i=0;i<4;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx, ny, n)) {
				if(loves.contains(map[ny][nx])){
					love++;
				}
			}
		}
		return love;
	}

	private static void bfs(int[][] map, int n, int[] love) {
		int student = love[0];
		Queue<Shark> pq = new PriorityQueue<>();
		Set<Integer> loves = new HashSet<>();
		for(int i=0;i<4;++i) {
			loves.add(love[i + 1]);
		}
		for(int i=0;i<map.length;++i) {
			for(int j=0;j<map.length;++j) {
				if(map[i][j] == 0) {
					Shark shark = find(map, loves, n, j, i);
					pq.offer(shark);
				}
			}	
		}
		Shark s = pq.poll();
		map[s.y][s.x] = student; 
	}

	private static int returnScore(int love) {
		if(love == 0) {
			return 0;
		}
		return (int) Math.pow(10, love - 1);
	}

	private static Shark find(int[][] map, Set<Integer> loves, int n, int x, int y) {
		Shark shark = new Shark(x, y, 0, 0);
		for(int i=0;i<4;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx, ny, n)) {
				if (map[ny][nx] == 0) {
					shark.addBlank();
				}else if(loves.contains(map[ny][nx])){
					shark.addLove();
				}
			}
		}
		return shark;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n*n][5];
		for(int i=0;i<n*n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<5;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr, n));
	}
}
