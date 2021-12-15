package progammers.level3;

import java.util.PriorityQueue;
import java.util.Queue;

class Item implements Comparable<Item>{
	int x;
	int y;
	int dis;
	public Item(int x,int y,int dis) {
		this.dis = dis;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Item o) {
		return this.dis - o.dis;
	}
}
public class 아이템줍기 {
	public static int answer;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean[][] visit;
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		answer = 0;
		int[][] map = new int[50 * 2][50 * 2];
		visit = new boolean[50*2][50*2];
		for(int[] rect : rectangle) {
			int startX = rect[0] - 1;
			int startY = rect[1] - 1;
			int endX = rect[2] - 1;
			int endY = rect[3] - 1;
			for(int y=startY*2; y<=endY*2; ++y) {
				for(int x=startX*2; x<=endX*2; ++x) {
					map[y][x] = 1;
				}
			}
		}
		for(int[] rect : rectangle) {
			int startX = rect[0] - 1;
			int startY = rect[1] - 1;
			int endX = rect[2] - 1;
			int endY = rect[3] - 1;
			for(int y=(startY*2)+1; y<=(endY*2)-1; ++y) {
				for(int x=(startX*2)+1; x<=(endX*2)-1; ++x) {
					map[y][x] = 0;
				}
			}
		}
		
		bfs(map,characterX-1,characterY-1,itemX-1,itemY-1);
		return answer;
	}
	private static void bfs(int[][] map, int x, int y, int endX, int endY) {
		Queue<Item> pq = new PriorityQueue<>();
		pq.offer(new Item(x*2, y*2, 0));
		int n = 100,m = 100;
		visit[y*2][x*2] = true;
		while(!pq.isEmpty()) {
			Item item = pq.poll();
			if(item.x == endX*2 && item.y == endY*2) {
				answer = item.dis / 2;
				return;
			}
			for(int i=0;i<4;++i) {
				int nx = item.x + dx[i];
				int ny = item.y + dy[i];
				if(isRange(nx,ny,n,m) && !visit[ny][nx] && map[ny][nx] == 1) {
					visit[ny][nx] = true;
					pq.offer(new Item(nx, ny, item.dis + 1));
				}
				
			}
		}
		
	} 
	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
	public static void main(String[] args) {
		//rectangle	characterX	characterY	itemX	itemY	result
		//[[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]	1	3	7	8	17
		//[[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]	9	7	6	1	11
		//[[1,1,5,7]]	1	1	4	7	9
		//[[2,1,7,5],[6,4,10,10]]	3	1	7	10	15
		//[[2,2,5,5],[1,3,6,4],[3,1,4,6]]	1	4	6	3	10
		int[][] rectangle1 = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		System.out.println(solution(rectangle1,1,3,7,8));
		int[][] rectangle2 = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
		System.out.println(solution(rectangle2, 9, 7, 6, 1));
		int[][] rectangle3 = {{1,1,5,7}};
		System.out.println(solution(rectangle3, 1, 1, 4, 7));
		int[][] rectangle4 = {{2,1,7,5},{6,4,10,10}};
		System.out.println(solution(rectangle4,3,1,7,10));
		int[][] rectangle5 = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
		System.out.println(solution(rectangle5,1,4,6,3));
	}

}
