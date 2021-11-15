package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Water{
	int x;
	int y;
	public Water(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 백조의호수 {
	public static boolean[][] visit;
	public static Water start = null;
	public static Water end = null;
	public static Queue<Water> waters;
	public static Queue<Water> que;
	public static Queue<Water> nextQue;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[r][c];
		for(int i=0;i<r;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map,r,c));
	}

	private static int solution(char[][] map, int r, int c) {
		int answer = 0;
		visit = new boolean[r][c];
		waters = new LinkedList<>();
		que = new LinkedList<>();
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(map[i][j] == '.') {
					waters.offer(new Water(j, i));
				}else if(map[i][j] == 'L') {
					if(start == null) {
						start = new Water(j, i);
					}else {
						end = new Water(j, i);
					}
				}
			}
		}
		waters.offer(start);
		waters.offer(end);
		que.offer(start);
		visit[start.y][start.x] = true;
		while(true) {
			if(find(map,r,c)) {
				break;
			}
			answer++;
			melt(map,r,c);
		}
		return answer;
	}

	private static void melt(char[][] map, int r, int c) {
		int size = waters.size();
		while(size-- > 0) {
			Water w = waters.poll();
			for(int i=0;i<4;++i) {
				int nx = w.x + dx[i];
				int ny = w.y + dy[i];
				if(isRange(nx,ny,r,c)  && map[ny][nx] == 'X') {
					waters.offer(new Water(nx, ny));
					map[ny][nx] = '.';
				}
			}
		}
	}

	private static boolean find(char[][] map, int r, int c) {
		nextQue = new LinkedList<>();
		while(!que.isEmpty()) {
			Water w = que.poll();
			if(w.x == end.x && w.y == end.y)
				return true;
			for(int i=0;i<4;++i) {
				int nx = w.x + dx[i];
				int ny = w.y + dy[i];
				if(isRange(nx,ny,r,c) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					if(map[ny][nx] == 'X') {
						nextQue.offer(new Water(nx, ny));
						continue;
					}
					que.offer(new Water(nx, ny));
				}
			}
		}
		que = nextQue;
		return false;
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny & ny < r;
	}

}
