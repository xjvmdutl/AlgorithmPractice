package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Ball{
	int x;
	int y;
	public Ball(int x, int y ) {
		this.x = x;
		this.y = y;
	}
}
class Game implements Comparable<Game>{
	Ball blue;
	Ball red;
	int count;
	public Game(Ball blue, Ball red, int count) {
		this.blue = blue;
		this.red = red;
		this.count = count;
	}
	@Override
	public int compareTo(Game o) {
		return this.count - o.count;
	}
}
public class 구슬탈출 {
	public static boolean[][][][] visit;
	public static boolean answer;
	public static int[] dx = {-1,1, 0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map, n, m));
		
	}

	private static int solution(char[][] map, int n, int m) {
		visit = new boolean[n][m][n][m];// B, R 방문여부
		Ball blue = null;
		Ball red = null;
		answer = false;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] == 'R')
					red = new Ball(j, i);
				else if(map[i][j] == 'B')
					blue = new Ball(j, i);
			}
		}
		bfs(map, n, m, red, blue);
		return answer ? 1 : 0;
	}

	private static void bfs(char[][] map, int n, int m, Ball red, Ball blue ) {
		Queue<Game> que = new PriorityQueue<>();
		visit[red.y][red.x][blue.y][blue.x] = true;
		que.offer(new Game(new Ball(blue.x, blue.y), new Ball(red.x, red.y), 0));
		while(!que.isEmpty()) {
			Game g = que.poll();
			Ball b = g.blue;
			Ball r = g.red;
			if (g.count > 10) {
				break;
			}
			for(int i=0;i<4;++i) {
				int bnx = b.x;
				int bny = b.y;
				int rnx = r.x;
				int rny = r.y;
				boolean isRedGoal = false;
				boolean isBlueGoal = false;
				//빨간공 move
				while(isRange(rnx, rny, n, m) && map[rny][rnx] != '#') {
					rnx += dx[i];
					rny += dy[i];
					if(map[rny][rnx] == 'O') {
						isRedGoal = true;
						break;
					}
				}
				//파란공 move
				while(isRange(bnx, bny, n, m) && map[bny][bnx] != '#') {
					bnx += dx[i];
					bny += dy[i];
					if(map[bny][bnx] == 'O') {
						isBlueGoal = true;
						break;
					}
				}
				
				if(isBlueGoal) {
					continue;
				}
				if(isRedGoal && g.count <= 9){
					answer = true;
					return;
				}
				// 경계면 -1
				rnx -= dx[i];
				rny -= dy[i];
				bnx -= dx[i];
				bny -= dy[i];
				if(bnx == rnx && bny == rny) {
					if(i == 0) {//더 왼쪽에 있는거먼저 실행
						if(b.x < r.x) { //파란색이 더 왼쪽
							rnx -= dx[i];
							rny -= dy[i];
						}else {
							bnx -= dx[i];
							bny -= dy[i];
						}
					}else if(i == 1) {//더 오른쪽에 있는거먼저 실행
						if(r.x < b.x) { //파란색이 더 오른쪽
							rnx -= dx[i];
							rny -= dy[i];
						}else {
							bnx -= dx[i];
							bny -= dy[i];
						}
					}else if(i == 2) { // 더 위쪽에 있는거 먼저 실행
						if(b.y < r.y) { //파란색이 더 위
							rnx -= dx[i];
							rny -= dy[i];
						}else {
							bnx -= dx[i];
							bny -= dy[i];
						}
					}else if(i == 3) { // 더 아래쪽 먼저 실행
						if(r.y < b.y) { //파란색이 더 아래쪽
							rnx -= dx[i];
							rny -= dy[i];
						}else {
							bnx -= dx[i];
							bny -= dy[i];
						}
					}
				}
				if(!visit[rny][rnx][bny][bnx]) {
					visit[rny][rnx][bny][bnx] = true;
					que.offer(new Game(
							new Ball(bnx, bny),
							new Ball(rnx, rny),
							g.count+1));
				}
			}
			
			
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

}
