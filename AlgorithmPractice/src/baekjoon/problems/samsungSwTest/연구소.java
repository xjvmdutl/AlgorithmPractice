package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Virus{
	int x;
	int y;
	public Virus(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class ¿¬±¸¼Ò {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visit;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(int[][] map, int n, int m) {
		answer = 0;
		
		dfs(map,n,m,0);
		return answer;
	}

	private static void dfs(int[][] map, int n, int m, int count) {
		if(count == 3) {
			bfs(map,n,m);
			return;
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(map, n, m, count+1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs(int[][] map, int n, int m) {
		int[][] tmpMap = new int[n][m];
		Queue<Virus> que = new LinkedList<>();
		visit = new boolean[n][m];
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				tmpMap[i][j] = map[i][j];
				if(tmpMap[i][j] == 2) {
					que.offer(new Virus(j, i));
					visit[i][j] = true;
				}
			}
		}
	
		
		
		while(!que.isEmpty()) {
			Virus v = que.poll();
			for(int i=0;i<4;++i) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if(0 <= nx && nx < m && 0 <= ny && ny < n) {
					if(!visit[ny][nx] && tmpMap[ny][nx] == 0) {
						que.offer(new Virus(nx, ny));
						visit[ny][nx] = true;
						tmpMap[ny][nx] = 2;
					}
				}
			}
		}
		answer = Math.max(Counting(tmpMap,n,m),answer);
	}

	private static int Counting(int[][] tmpMap, int n, int m) {
		int count = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(tmpMap[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

}
