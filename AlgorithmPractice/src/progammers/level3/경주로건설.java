package progammers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Build implements Comparable<Build>{
	int x;
	int y;
	int dir;
	int money;
	public Build(int x,int y,int dir,int money) {
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.money = money;
	}
	@Override
	public int compareTo(Build o) {
		return this.money - o.money;
	}
	
}
public class 경주로건설 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer;
	public static int[][][] visit;
	public static int solution(int[][] board) {
        answer = 0;
        int n = board.length;
        int m = board[0].length;
        visit = new int[4][n][m];
        for(int i=0;i<4;++i) {
	        for(int j=0;j<n;++j) {
	        	Arrays.fill(visit[i][j], Integer.MAX_VALUE);
	        }
        }
        bfs(board,n,m);
        return answer;
    }
	private static void bfs(int[][] board, int n, int m) {
		Queue<Build> pq = new PriorityQueue<>();
		pq.offer(new Build(0, 0, 1, 0));
		pq.offer(new Build(0, 0, 3, 0));
		visit[1][0][0] = 0;
		visit[3][0][0] = 0;
		while(!pq.isEmpty()) {
			Build b = pq.poll();
			if(b.x == m-1 && b.y == n-1) {
				answer = b.money;
				return;
			}
			for(int i=0;i<4;++i) {
				int nx = b.x + dx[i];
				int ny = b.y + dy[i];
				int money = b.dir == i ? b.money + 100 : b.money + 600;
				if(isRange(nx,ny,n,m) && visit[i][ny][nx] > money &&board[ny][nx] == 0) {
					visit[i][ny][nx] = money;
					pq.offer(new Build(nx, ny, i, money));
				}
			}
		}
	}
	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
	public static void main(String[] args) {
		//board	result
		//[[0,0,0],[0,0,0],[0,0,0]]	900
		//[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]	3800
		//[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]	2100
		//[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]	3200
		int[][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(board1));
		int[][] board2 = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		System.out.println(solution(board2));
		int[][] board3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		System.out.println(solution(board3));
		int[][] board4 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		System.out.println(solution(board4));
	}

}
