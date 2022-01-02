package progammers.level3;

import java.util.PriorityQueue;
import java.util.Queue;

public class 블록이동하기 {
	
	static class Point{
		int x;
		int y;
		public Point(int x,int y){
			this.x = x;
			this.y =y;
		}
	}
	static class Robot implements Comparable<Robot>{
		Point p1;
		Point p2;
		int time;
		public Robot(Point p1,Point p2,int time){
			this.p1 = p1;
			this.p2 = p2;
			this.time = time;
		}
		@Override
		public int compareTo(Robot o) {
			return this.time - o.time;
		}
	}
	public static boolean[][][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer;
	public static int solution(int[][] board) {
        answer = 0;
        visit = new boolean[2][board.length][board[0].length];
        bfs(board,board.length,board[0].length);
        return answer;
    }
	private static void bfs(int[][] board, int n, int m) {
		Queue<Robot> que = new PriorityQueue<>();
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 0);
		que.offer(new Robot(point1,point2,0));
		visit[0][0][0] = true;
		visit[0][0][1] = true;
		while(!que.isEmpty()) {
			Robot r = que.poll();
			//왼쪽 축
			Point p1 = r.p1;
			//오른쪽 축
			Point p2 = r.p2;
			if((p2.y == n-1 && p2.x == m-1)) {
				answer = r.time;
				return;
			}
			//상하좌우 이동
			//직진
			for(int i=0;i<4;++i) {
				int p1X = p1.x + dx[i];
				int p1Y = p1.y + dy[i];
				int p2X = p2.x + dx[i];
				int p2Y = p2.y + dy[i];
				if(isRange(p1X,p1Y,n,m) 
				&& isRange(p2X,p2Y,n,m)
				&& board[p1Y][p1X] == 0
				&& board[p2Y][p2X] == 0) {
					if(p1X == p2X) {
						if(!visit[1][p1Y][p1X] || !visit[1][p2Y][p2X]) {
							visit[1][p1Y][p1X] =true;
							visit[1][p2Y][p2X] =true;
							que.offer(new Robot(new Point(Math.min(p1X, p2X),Math.min(p1Y, p2Y)), 
									new Point(Math.max(p1X, p2X),Math.max(p1Y, p2Y)), 
									r.time+1));
						}
					}else {
						if(!visit[0][p1Y][p1X] || !visit[0][p2Y][p2X]) {
							visit[0][p1Y][p1X] =true;
							visit[0][p2Y][p2X] =true;
							que.offer(new Robot(new Point(Math.min(p1X, p2X),Math.min(p1Y, p2Y)), 
									new Point(Math.max(p1X, p2X),Math.max(p1Y, p2Y)), 
									r.time+1));
						}
					}
				}
			}
			
			if(p1.x == p2.x) { // |
				//회전
				//위축
				for(int i=0;i<2;++i) {
					int nnX = p1.x + dx[i];
					int nnY = p1.y + dy[i];
					int tmpX = p2.x + dx[i]; //거쳐가는 곳
					int tmpY = p2.y + dy[i];
					if(
					isRange(tmpX,tmpY,n,m) 
					&& isRange(nnX,nnY,n,m) 
					&& (!visit[0][nnY][nnX] 
					|| !visit[0][p1.y][p1.x]) 
					&& board[tmpY][tmpX] == 0 
					&& board[nnY][nnX] == 0 ) {
						visit[0][nnY][nnX] = true;
						visit[0][p1.y][p1.x] = true;
						que.offer(new Robot(new Point(Math.min(nnX, p1.x),Math.min(nnY, p1.y)), 
											new Point(Math.max(nnX, p1.x),Math.max(nnY, p1.y)), 
											r.time+1));
					}
					nnX = p2.x + dx[i];
					nnY = p2.y + dy[i];
					tmpX = p1.x + dx[i]; //거쳐가는 곳
					tmpY = p1.y + dy[i];
					if(
					isRange(tmpX,tmpY,n,m) 
					&& isRange(nnX,nnY,n,m) 
					&& (!visit[0][nnY][nnX] 
					|| !visit[0][p2.y][p2.x]) 
					&& board[tmpY][tmpX] == 0 
					&& board[nnY][nnX] == 0 ) {
						visit[0][nnY][nnX] = true;
						visit[0][p2.y][p2.x] = true;
						que.offer(new Robot(new Point(Math.min(nnX, p2.x),Math.min(nnY, p2.y)), 
								new Point(Math.max(nnX, p2.x),Math.max(nnY, p2.y)), 
								r.time+1));
					}
				}
			}else if(p1.y == p2.y) { // -
				//회전
				//좌측
				for(int i=2;i<4;++i) {
					int nnX = p1.x + dx[i];
					int nnY = p1.y + dy[i];
					int tmpX = p2.x + dx[i]; //거쳐가는 곳
					int tmpY = p2.y + dy[i];
					if(
					isRange(tmpX,tmpY,n,m) 
					&& isRange(nnX,nnY,n,m) 
					&& (!visit[1][nnY][nnX] 
					|| !visit[1][p1.y][p1.x]) 
					&& board[tmpY][tmpX] == 0 
					&& board[nnY][nnX] == 0 ) {
						visit[1][nnY][nnX] = true;
						visit[1][p1.y][p1.x] = true;
						que.offer(new Robot(new Point(Math.min(nnX, p1.x),Math.min(nnY, p1.y)), 
								new Point(Math.max(nnX, p1.x),Math.max(nnY, p1.y)), 
								r.time+1));
					}
					nnX = p2.x + dx[i];
					nnY = p2.y + dy[i];
					tmpX = p1.x + dx[i]; //거쳐가는 곳
					tmpY = p1.y + dy[i];
					if(
						isRange(tmpX,tmpY,n,m) 
						&& isRange(nnX,nnY,n,m) 
						&& (!visit[1][nnY][nnX] 
						|| !visit[1][p2.y][p2.x]) 
						&& board[tmpY][tmpX] == 0 
						&& board[nnY][nnX] == 0 ) {
							visit[1][nnY][nnX] = true;
							visit[1][p2.y][p2.x] = true;
							que.offer(new Robot(new Point(Math.min(nnX, p2.x),Math.min(nnY, p2.y)), 
									new Point(Math.max(nnX, p2.x),Math.max(nnY, p2.y)), 
									r.time+1));
					}
				}
				
			}
		}
	}
	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
	
	
	public static void main(String[] args) {
		/*
		//board	result
		//[[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]	7
		int[][] board = {{0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, 
						 {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, 
						 {1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
						 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						 {0, 0, 1, 1, 1, 0, 0, 0, 0, 0}, 
						 {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
						 {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, 
						 {0, 0, 0, 0, 0, 0, 1, 1, 0, 1}, 
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		System.out.println(solution(board));
		
		input :
		[[0, 0, 0, 0, 0, 0, 1], [1, 1, 1, 1, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0], [0, 0, 1, 1, 1, 1, 0], [0, 1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 1, 1], [0, 0, 1, 0, 0, 0, 0]]
		result : 21
	
		input : [[0, 0, 0, 0, 0, 0, 1], [1, 1, 1, 1, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0], [0, 0, 1, 1, 1, 0, 0], [0, 1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 1, 0], [0, 0, 1, 0, 0, 0, 0]]
		result : 11
	
		input: [[0, 0, 0, 0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 0, 0], [1, 1, 1, 1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 1, 1, 1, 1, 1, 0, 0], [0, 1, 1, 1, 1, 1, 1, 1, 1], [0, 0, 1, 1, 1, 1, 1, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 1, 0]]
		result : 33
		 */
		int[][] board1 = {
				{0, 0, 0, 0, 0, 0, 1}, 
				{1, 1, 1, 1, 0, 0, 1}, 
				{0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 1, 1, 1, 1, 0}, 
				{0, 1, 1, 1, 1, 1, 0}, 
				{0, 0, 0, 0, 0, 1, 1}, 
				{0, 0, 1, 0, 0, 0, 0}};
		System.out.println(solution(board1));
	}

}
