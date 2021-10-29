package progammers.weekly;

import java.util.PriorityQueue;
import java.util.Queue;
class Point01 implements Comparable<Point01>{
	int x;
	int y;
	int dis;
	public Point01(int x,int y,int dis){
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
	@Override
	public int compareTo(Point01 o) {
		return this.dis - o.dis;
	}
}
public class 아이템줍기 {
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean[][] visit;
	public static int answer;
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = new int[102][102];
        for(int[] rect : rectangle) {
	    	for(int y = rect[1] *2; y <= rect[3] *2; y++){
	    		for(int x = rect[0] * 2; x <= rect[2] * 2; x++){
	    			map[y][x] = 1;
	            }
	        }
        }
        //안쪽을 0으로 채움
        for(int[] rect : rectangle) {
            for(int y = rect[1] *2 + 1; y <= rect[3] *2 - 1; y++){
                for(int x = rect[0] * 2 + 1; x <= rect[2] * 2 - 1; x++){
                    map[y][x] = 0;
                }
            }
        }
        return bfs(map,characterX,characterY,itemX,itemY);
    }
	
	private static int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
		Queue<Point01> que = new PriorityQueue<>();
		visit = new boolean[102][102];
		que.offer(new Point01(characterX*2, characterY*2, 0));
		visit[characterY*2][characterX*2] = true;
		while(!que.isEmpty()) {
			Point01 p = que.poll();
			if(p.x == itemX*2 && p.y == itemY*2) {
				return p.dis/2;
			}
			for(int i=0;i<4;++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(isRange(nx,ny) && !visit[ny][nx] && map[ny][nx] == 1) {
					visit[ny][nx] = true;
					que.offer(new Point01(nx, ny, p.dis + 1));
				}
			}
		}
		return -1;
	}

	private static boolean isRange(int nx, int ny) {
		return 0 <= nx && nx < 102 && 0 <= ny && ny < 102;
	}

	public static void main(String[] args) {
		//rectangle	characterX	characterY	itemX	itemY	result
		//[[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]	1	3	7	8	17
		//[[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]	9	7	6	1	11
		//[[1,1,5,7]]	1	1	4	7	9
		//[[2,1,7,5],[6,4,10,10]]	3	1	7	10	15
		//[[2,2,5,5],[1,3,6,4],[3,1,4,6]]	1	4	6	3	10
		int[][] rectangle1 = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		int characterX1 = 1;
		int characterY1 = 3;
		int itemX1 = 7;
		int itemY1 = 8;
		System.out.println(solution(rectangle1,characterX1,characterY1,itemX1,itemY1));
		int[][] rectangle2 = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
		int characterX2 = 9;
		int characterY2 = 7;
		int itemX2 = 6;
		int itemY2 = 1;
		System.out.println(solution(rectangle2,characterX2,characterY2,itemX2,itemY2));
		int[][] rectangle3 = {{1,1,5,7}};
		int characterX3 = 1;
		int characterY3 = 1;
		int itemX3 = 4;
		int itemY3 = 7;
		System.out.println(solution(rectangle3,characterX3,characterY3,itemX3,itemY3));
		int[][] rectangle4 = {{2,1,7,5},{6,4,10,10}};
		int characterX4 = 3;
		int characterY4 = 1;
		int itemX4 = 7;
		int itemY4 = 10;
		System.out.println(solution(rectangle4,characterX4,characterY4,itemX4,itemY4));
		int[][] rectangle5 = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
		int characterX5 = 1;
		int characterY5 = 4;
		int itemX5 = 6;
		int itemY5 = 3;
		System.out.println(solution(rectangle5,characterX5,characterY5,itemX5,itemY5));
		

	}

}
