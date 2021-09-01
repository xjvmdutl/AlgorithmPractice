package progammers.level2.review;

import java.util.LinkedList;
import java.util.Queue;

class map{
	int x;
	int y;
	int count;
	public map(int x,int y,int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
public class 게임맵최단거리 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visit;
	public static int N,M,answer;
	public static int solution(int[][] maps) {
        answer = -1;
        N = maps.length;
        M = maps[0].length;
        visit = new boolean[N][M];
        bfs(maps);
        return answer;
    }
	private static void bfs(int[][] maps) {
		Queue<map> que = new LinkedList<>();
		que.offer(new map(0,0,1));
		visit[0][0] = true;
		while(!que.isEmpty()) {
			map m = que.poll();
			if(m.x == M-1 && m.y == N-1) {
				answer = m.count;
				return;
			}
			for(int i=0;i<4;++i) {
				int nx = m.x + dx[i];
				int ny = m.y + dy[i];
				if(0 <= nx && nx < M && 0 <= ny && ny < N) {
					if(!visit[ny][nx] && maps[ny][nx] == 1) {
						visit[ny][nx] = true;
						que.offer(new map(nx, ny, m.count+1));
					}
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
