package progammers.level3;

import java.util.LinkedList;
import java.util.Queue;
class Point{
	int x;
	int y;
	public Point(int x,int y){
		this.x = x;
		this.y =y;
	}
}
class Robot{
	Point p1;
	Point p2;
	int time;
	int rotation;
	public Robot(Point p1,Point p2,int time,int rotation){
		this.p1 = p1;
		this.p2 = p2;
		this.time = time;
		this.rotation = rotation;
	}
}
public class 블록이동하기 {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer;
	public static int solution(int[][] board) {
        answer = 0;
        visit = new boolean[board.length][board[0].length];
        bfs(board,board.length,board[0].length);
        
        return answer;
    }
	private static void bfs(int[][] board, int n, int m) {
		Queue<Robot> que = new LinkedList<>();
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 0);
		que.offer(new Robot(point1,point2,0,0));
		visit[0][0] = true;
		visit[0][1] = true;
		while(!que.isEmpty()) {
			Robot r = que.poll();
			//왼쪽 축
			Point p1 = r.p1;
			Point p2 = r.p2;
			if(p2.y == n-1 && p2.x == m-1) {
				answer = r.time;
				break;
			}
			if(r.rotation == 0) {//우측
				if(0 <= p2.x+1 && p2.x+1 < m && 0 <= p2.y && p2.y < n) {
					if(!visit[p2.y][p2.x+1] && board[p2.y][p2.x+1] == 0) {
						visit[p2.y][p2.x+1] = true;
						Point tmp1 = new Point(p1.x+1,p1.y);
						Point tmp2 = new Point(p2.x+1,p2.y);
						que.offer(new Robot(tmp1, tmp2,r.time+1,0));
					}
				}
			}else {//하강
				if(0 <= p2.x && p2.x < m && 0 <= p2.y+1 && p2.y+1 < n) {
					if(!visit[p2.y+1][p2.x] && board[p2.y+1][p2.x] == 0) {
						visit[p2.y+1][p2.x] = true;
						Point tmp1 = new Point(p1.x,p1.y+1);
						Point tmp2 = new Point(p2.x,p2.y+1);
						que.offer(new Robot(tmp1, tmp2,r.time+1,1));
					}
				}
			}
			for(int i=0;i<4;++i) {
				if(r.rotation == 1) {
					if(i==2 || i ==3) {
						continue;
					}
				}else {
					if(i==0 || i ==1) {
						continue;
					}
				}
				int nx1 = p1.x + dx[i];
				int ny1 = p1.y + dy[i];
				int nx2 = p2.x + dx[i];
				int ny2 = p2.y + dy[i];
				if(0 <= nx1 && nx1 < m && 0 <= nx2 && nx2 < m
						&& 0 <= ny1 && ny1 < n && 0 <= ny2 && ny2 < n) {
					if(!visit[ny1][nx1] && board[ny1][nx1] == 0 && board[ny2][nx2] == 0) {
						visit[ny1][nx1] = true;
						Point tmp1 = null;
						Point tmp2 = null;
						if(nx1 < p1.x) {
							tmp1 = new Point(nx1, ny1);
							tmp2 = new Point(p1.x, p1.y);
						}else if(nx1 > p1.x){
							tmp1 = new Point(p1.x, p1.y);
							tmp2 = new Point(nx1, ny1);
						}else if(ny1 < p1.y) {
							tmp1 = new Point(nx1, ny1);
							tmp2 = new Point(p1.x, p1.y);
						}else if(ny1 > p1.y) {
							tmp1 = new Point(p1.x, p1.y);
							tmp2 = new Point(nx1, ny1);
						}
						que.offer(new Robot(tmp1, tmp2,r.time+1,r.rotation == 0 ? 1:0));
					}
				}
			}
			
			//오른축
			for(int i=0;i<4;++i) {
				if(r.rotation == 1) {
					if(i==2 || i ==3) {
						continue;
					}
				}else {
					if(i==0 || i ==1) {
						continue;
					}
				}
				int nx1 = p1.x + dx[i];
				int ny1 = p1.y + dy[i];
				int nx2 = p2.x + dx[i];
				int ny2 = p2.y + dy[i];
				if(0 <= nx1 && nx1 < m && 0 <= nx2 && nx2 < m
						&& 0 <= ny1 && ny1 < n && 0 <= ny2 && ny2 < n) {
					if(!visit[ny2][nx2] && board[ny1][nx1] == 0 && board[ny2][nx2] == 0) {
						visit[ny2][nx2] = true;
						Point tmp1 = null;
						Point tmp2 = null;
						if(nx2 < p2.x) {
							tmp1 = new Point(nx2, ny2);
							tmp2 = new Point(p2.x, p2.y);
						}else if(nx2 > p2.x){
							tmp1 = new Point(p2.x, p2.y);
							tmp2 = new Point(nx2, ny2);
						}else if(ny2 < p2.y) {
							tmp1 = new Point(nx2, ny2);
							tmp2 = new Point(p2.x, p2.y);
						}else if(ny2 > p2.y) {
							tmp1 = new Point(p2.x, p2.y);
							tmp2 = new Point(nx2, ny2);
						}
						que.offer(new Robot(tmp1, tmp2,r.time+1,r.rotation == 0 ? 1:0));
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		//board	result
		//[[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]	7
		int[][] board = {{0, 0, 0, 1, 1}
						,{0, 0, 0, 0, 0}
						,{0, 1, 1, 1, 0}
						,{0, 1, 0, 0, 0}
						,{0, 0, 0, 0, 0}};
		System.out.println(solution(board));
	
	}

}
