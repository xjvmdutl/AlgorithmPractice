package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¿¬±¸¼Ò {
	
	private static final int BLANK = 0;
	private static final int WALL = 1;
	private static final int VIRUS = 2;
	private static final int MAX_WALL_COUNT = 3;
	private static final int[] dx = {-1,1,0,0};
	private static final int[] dy = {0,0,-1,1};
	private static int answer;
	static class Virus{
		int x;
		int y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
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
		answer = 0;
		permutation(map, n, m, 0);
		return answer;
	}

	private static void permutation(int[][] map, int n, int m, int count) {
		if(count == MAX_WALL_COUNT) {
			int[][] splitMap = splitVirus(map, n, m, count);
			answer = Math.max(answer, counting(splitMap, n, m));
			return;
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(isBlank(map[i][j])) {
					map[i][j] = WALL;
					permutation(map, n, m, count+1);
					map[i][j] = BLANK;
				}
			}	
		}
	}

	private static int[][] splitVirus(int[][] map, int n, int m, int count) {
		return getSplitMap(map, n, m);
	}


	private static int[][] getSplitMap(int[][] map, int n, int m) {
		int[][] result = new int[n][m];
		List<Virus> viruses = new ArrayList<>();
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				result[i][j] = map[i][j];
				if(isVirus(map[i][j])) {
					viruses.add(new Virus(j, i));
				}
			}	
		}
		split(result, viruses, n, m);
		return result;
	}

	private static void split(int[][] result, List<Virus> viruses, int n, int m) {
		boolean[][] visit = new boolean[n][m];
		for(Virus virus : viruses) {
			Queue<Virus> que = new LinkedList<>();
			if(visit[virus.y][virus.x])
				continue;
			visit[virus.y][virus.x] = true;
			que.offer(new Virus(virus.x, virus.y));
			while(!que.isEmpty()) {
				Virus v = que.poll();
				for(int i=0;i<4;++i) {
					int nx = v.x + dx[i];
					int ny = v.y + dy[i];
					if(isRange(nx, ny, n, m) && !visit[ny][nx] && isBlank(result[ny][nx])) {
						result[ny][nx] = VIRUS;
						que.offer(new Virus(nx, ny));
						visit[ny][nx] = true;
					}
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

	private static boolean isVirus(int map) {
		return map == VIRUS;
	}

	private static int counting(int[][] splitMap, int n, int m) {
		int count = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(isBlank(splitMap[i][j])) {
					count++;
				}
			}
		}
		return count;
	}
	private static boolean isBlank(int map) {
		return map == BLANK;
	}

}
