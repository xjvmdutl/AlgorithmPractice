package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Place{
	int x;
	int y;
	int drill;
	int distance;
	public Place(int x,int y,int drill,int distance) {
		this.x = x;
		this.y = y;
		this.drill = drill;
		this.distance = distance;
	}
}
public class 벽부수고이동하기 {
	
	public static int[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[n][m];
		for(int i=0;i<n;++i) {
			String[] strs = reader.readLine().split("");
			for(int j=0;j<m;++j) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		System.out.println(solution(arr,n,m));
	}

	private static int solution(int[][] arr, int n, int m) {
		
		visit = new int[n][m];
		for(int i=0;i<n;++i) {
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		int answer = bfs(n,m,arr);
		return answer;
	}

	private static int bfs(int n, int m, int[][] arr) {
		Queue<Place> que = new LinkedList<>();
		que.offer(new Place(0, 0, 0, 1));
		visit[0][0] = 0;
		int count = -1;
		while(!que.isEmpty()) {
			Place p = que.poll();
			if(p.y == n-1 && p.x == m - 1) {
				count = p.distance;
				break;
			}
				
			for(int i=0;i<4;++i) {
				int x = dx[i] + p.x;
				int y = dy[i] + p.y;
				if(0 <= x && x < m && 0 <= y && y < n) {
					if(visit[y][x] > p.drill) {
						//벽이 아닐 때
						if(arr[y][x] == 0) {
							visit[y][x] = p.drill;
							que.offer(new Place(x, y, p.drill, p.distance + 1));
						}else {
							if(p.drill == 0) {
								visit[y][x] = p.drill + 1;
								que.offer(new Place(x, y, p.drill+1, p.distance + 1));
							}
						}
						
					}
				}
			}
		}
		return count;
	}

}
