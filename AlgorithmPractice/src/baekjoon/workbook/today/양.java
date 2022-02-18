package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Backyard{
	int x;
	int y;
	public Backyard(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public static boolean isSheep(char[][] map, int nx, int ny) {
		return map[ny][nx] == 'o';
	}
	public static boolean isWolf(char[][] map, int nx, int ny) {
		return map[ny][nx] == 'v';
	}
}
public class ¾ç {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[r][c];
		for(int i=0;i<r;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map, r, c));
	}

	private static String solution(char[][] map, int r, int c) {
		visit = new boolean[r][c];
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(!visit[i][j] && map[i][j] != '#') {
					bfs(map,i,j,r,c);
				}
			}
		}
		return counting(map, r, c);
		
	}

	private static String counting(char[][] map,int r, int c) {
		StringBuilder sb = new StringBuilder();
		int wolf = 0;
		int sheep = 0;
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(Backyard.isWolf(map, j, i)) {
					wolf++;
				}else if(Backyard.isSheep(map, j, i)) {
					sheep++;
				}
			}
		}
		sb.append(sheep + " " + wolf);
		return sb.toString();
	}

	private static void bfs(char[][] map, int y, int x, int r, int c) {
		Queue<Backyard> que = new LinkedList<>();
		que.offer(new Backyard(x, y));
		visit[y][x] = true;
		List<Backyard> wolfes = new ArrayList<>();
		List<Backyard> sheppes = new ArrayList<>();
		if(Backyard.isWolf(map, x, y)) {
			wolfes.add(new Backyard(x, y));
		}else if(Backyard.isSheep(map, x, y)) {
			sheppes.add(new Backyard(x, y));
		}
		
		while(!que.isEmpty()) {
			Backyard b = que.poll();
			for(int i=0;i<4;++i) {
				int nx = dx[i] + b.x;
				int ny = dy[i] + b.y;
				if(isRange(nx,ny,r,c) && !visit[ny][nx] && map[ny][nx] != '#') {
					visit[ny][nx] = true;
					if(Backyard.isWolf(map, nx, ny)) {
						wolfes.add(new Backyard(nx, ny));
					}else if(Backyard.isSheep(map, nx, ny)) {
						sheppes.add(new Backyard(nx, ny));
					}
					que.offer(new Backyard(nx, ny));
				}
			}
		}
		if(sheppes.size() <= wolfes.size()) {
			for(Backyard b : sheppes) {
				map[b.y][b.x] = '.'; 
			}
		}else {
			for(Backyard b : wolfes) {
				map[b.y][b.x] = '.'; 
			}
		}
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny && ny < r;
	}

}
