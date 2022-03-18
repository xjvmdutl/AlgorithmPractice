package test.ahnlab;

import java.util.PriorityQueue;
import java.util.Queue;

class Block implements Comparable<Block> {
	int x;
	int y;
	int count;

	public Block(int x, int y, int count) {
		this.count = count;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Block o) {
		return this.count - o.count;
	}
}

public class test02 {
	public static boolean[][] visit;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static Block start;
	public static int answer = 0;

	public static int solution(int n, int[][] board) {
		answer = 0;
		start = new Block(0, 0, 0);
		for (int i = 1; i <= n * n; ++i) {
			bfs(board, i, n);
		}
		return answer;
	}

	private static void bfs(int[][] board, int num, int n) {
		visit = new boolean[n][n];
		Queue<Block> que = new PriorityQueue<>();
		que.offer(new Block(start.x, start.y, 0));
		visit[start.y][start.x] = true;
		while (!que.isEmpty()) {
			Block b = que.poll();
			if (board[b.y][b.x] == num) {
				start = new Block(b.x, b.y, 0);
				answer += b.count + 1;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = b.x + dx[i];
				int ny = b.y + dy[i];
				if (nx < 0) {
					nx = n - 1;
				} else if (ny < 0) {
					ny = n - 1;
				} else if (nx >= n) {
					nx = 0;
				} else if (ny >= n) {
					ny = 0;
				}
				if (!visit[ny][nx]) {
					visit[ny][nx] = true;
					que.offer(new Block(nx, ny, b.count + 1));
				}
			}
		}
	}

	public static void main(String[] args) {
		int n1 = 3;
		int n2 = 2;
		int n3 = 4;
		int[][] board1 = { { 3, 5, 6 }, { 9, 2, 7 }, { 4, 1, 8 } };
		int[][] board2 = { { 2,3 }, { 4,1 }};
		int[][] board3 = { {11,9,8,12 }, {2,15,4,14 }, { 1,10,16,3 }, { 13,7,5,6 } };
		System.out.println(solution(n1, board1));
		System.out.println(solution(n2, board2));
		System.out.println(solution(n3, board3));
	}

}
