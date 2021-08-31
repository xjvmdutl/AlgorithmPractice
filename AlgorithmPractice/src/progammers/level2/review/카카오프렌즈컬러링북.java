package progammers.level2.review;

import java.util.LinkedList;
import java.util.Queue;
class Book{
	int x;
	int y;
	public Book(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class Ä«Ä«¿ÀÇÁ·»ÁîÄÃ·¯¸µºÏ {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int maxSizeOfOneArea;
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        visit = new boolean[m][n];
        maxSizeOfOneArea = 0;
        for(int i=0;i<m;++i) {
        	for(int j=0;j<n;++j) {
        		if(!visit[i][j] && picture[i][j] > 0) {
        			numberOfArea++;
        			bfs(picture,j,i,picture[i][j],m,n);
        		}
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	private static void bfs(int[][] picture, int x, int y, int value, int m, int n) {
		Queue<Book> que = new LinkedList<>();
		visit[y][x] = true;
		que.offer(new Book(x, y));
		int sum = 1;
		while(!que.isEmpty()) {
			Book b = que.poll();
			for(int i=0;i<4;++i) {
				int nx = b.x + dx[i];
				int ny = b.y + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < m) {
					if(!visit[ny][nx] && picture[ny][nx] == value) {
						visit[ny][nx] = true;
						que.offer(new Book(nx, ny));
						sum++;
					}
				}
			}
		}
		maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sum);
	}
	public static void main(String[] args) {
		//m	n	picture	answer
		//6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(solution(m,n,picture));
	}

}
