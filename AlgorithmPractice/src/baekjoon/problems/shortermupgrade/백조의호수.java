package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class BackJo{
	int x;
	int y;
	public BackJo(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 백조의호수 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean[][] visit;
	public static Queue<BackJo> nextQue;
	public static Queue<BackJo> que;
	public static Queue<BackJo> waterQue;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[r][c];
		for(int i=0;i<r;++i) {
			String str = reader.readLine();
			for(int j=0;j<c;++j) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(solution(map,r,c));
	}
	private static int solution(char[][] map, int r, int c) {
		int answer = 0;
		waterQue = new LinkedList<>();
		que = new LinkedList<>();
		visit = new boolean[r][c];
		BackJo first = null;
		BackJo second = null;
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(map[i][j] == 'L') {
					if(first != null) {
						second = new BackJo(j, i);
					}else {
						first = new BackJo(j, i);
					}
				}
				if(map[i][j] == '.')
					waterQue.offer(new BackJo(j, i));
			}
		}
		waterQue.offer(first);
		waterQue.offer(second);
		que.offer(first);
		visit[first.y][first.x] = true;
		while(true) {
			if(find(map,r,c,first,second))
				break;
			spread(map,r,c);
			answer++;
		}
		return answer;
	}
	private static void spread(char[][] map, int r, int c) {
		int size = waterQue.size();
		for(int i=0;i<size;++i) {
			BackJo b = waterQue.poll();
			for(int j=0;j<4;++j) {
				int nx = b.x + dx[j];
				int ny = b.y + dy[j];
				if(isRange(nx, ny, r, c) && map[ny][nx] == 'X') {
					map[ny][nx] = '.';
					waterQue.offer(new BackJo(nx, ny));
				}
			}
		}
	}
	private static boolean find(char[][] map, int r, int c, BackJo first, BackJo second) {
		nextQue = new LinkedList<BackJo>();
		while(!que.isEmpty()) {
			BackJo b = que.poll();
			if(b.x == second.x && b.y == second.y)
				return true;
			for(int i=0;i<4;++i) {
				int nx = b.x + dx[i];
				int ny = b.y + dy[i];
				if(isRange(nx,ny,r,c) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					if(map[ny][nx] == 'X') {
						nextQue.offer(new BackJo(nx, ny));
						continue;
					}
					que.offer(new BackJo(nx, ny));
				}
			}
		}
		que = nextQue;
		return false;
	}
	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny && ny < r;
	}

}
