package progammers.level2;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PointGame {
	int x;
	int y;
	public PointGame(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 게임맵최단거리 {
	static boolean[][] isVisited;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static int solution(int[][] maps) {
		int row = maps.length;
		int col = maps[0].length;
		isVisited = new boolean[row][col];
		map = new int[row][col];
		for(int[] rows : map) {
			Arrays.fill(rows, -1);
		}
		bfs(0,0,maps);
		return map[row-1][col-1];
	}
	private static void bfs(int x, int y, int[][] maps) {
		Queue<PointGame> queue = new LinkedList<>();
		queue.offer(new PointGame(x, y));
		isVisited[x][y]= true;
		map[x][y] = 1;
		while(!queue.isEmpty()) {
			PointGame now = queue.poll();
			for(int i=0;i<4;++i) {
				int tx = now.x + dx[i];
				int ty = now.y + dy[i];
				if(tx < 0 || maps.length <= tx || ty < 0 || maps[0].length <= ty ) {
					continue;
				}
				if(maps[tx][ty] == 0) continue;
				if(!isVisited[tx][ty]) {
					isVisited[tx][ty] = true;
					map[tx][ty] = map[now.x][now.y] +1;
					queue.offer(new PointGame(tx,ty));
				}
			}
		}
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//maps	answer
		//[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
		//[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
		int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps1));
		int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(solution(maps2));
	}

}
