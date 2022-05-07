package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 단지번호붙이기 {
	private static boolean[][] visit;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	static class Home{
		int x;
		int y;
		public Home(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[][] map = new char[n][n];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map, n));
	}

	private static String solution(char[][] map, int n) {
		List<Integer> answer = new ArrayList<>();
		visit = new boolean[n][n];
		find(map, n, answer);
		return print(answer);
	}

	private static void find(char[][] map, int n, List<Integer> answer) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(isNotVisit(map, i, j)) {
					bfs(map, j, i, n, answer);
				}
			}	
		}
	}

	private static boolean isNotVisit(char[][] map, int y, int x) {
		return !visit[y][x] && map[y][x] == '1';
	}
	
	private static void bfs(char[][] map, int x, int y, int n, List<Integer> answer) {
		Queue<Home> que = new LinkedList<>();
		visit[y][x] = true;
		que.offer(new Home(x, y));
		int count = 1;
		while(!que.isEmpty()) {
			Home home = que.poll();
			for(int i=0;i<4;++i) {
				int nx = home.x + dx[i];
				int ny = home.y + dy[i];
				if(isRange(nx, ny, n) && isNotVisit(map, ny, nx)) {
					visit[ny][nx] = true;
					count++;
					que.offer(new Home(nx, ny));
				}
			}
		}
		answer.add(count);
	}
	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

	private static String print(List<Integer> list) {
		Collections.sort(list);
		StringBuilder answer = new StringBuilder();
		answer.append(list.size() + "\n");
		for(int number : list) {
			answer.append(number + " \n");
		}
		return answer.toString();
	}

}
