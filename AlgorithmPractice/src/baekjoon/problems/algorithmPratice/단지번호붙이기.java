package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Danji{
	int x;
	int y;
	public Danji(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 단지번호붙이기 {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[][] map = new char[n][n];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map,n));
	}

	private static String solution(char[][] map, int n) {
		StringBuilder sb = new StringBuilder();
		visit = new boolean[n][n];
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] == '1' && !visit[i][j]) {
					list.add(bfs(map,j,i,n));
				}
			}
		}
		sb.append(list.size() + "\n");
		Collections.sort(list);
		for(int i=0;i<list.size();++i)
			sb.append(list.get(i) + "\n");
		return sb.toString();
	}

	private static int bfs(char[][] map, int x, int y,int n) {
		Queue<Danji> que = new LinkedList<>();
		int size = 0;
		visit[y][x] = true;
		que.offer(new Danji(x, y));
		while(!que.isEmpty()) {
			Danji d = que.poll();
			size++;
			for(int i=0;i<4;++i) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if(isRange(nx,ny,n) && !visit[ny][nx] && map[ny][nx] == '1') {
					que.offer(new Danji(nx, ny));
					visit[ny][nx] = true;
				}
			}
		}
		return size;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
