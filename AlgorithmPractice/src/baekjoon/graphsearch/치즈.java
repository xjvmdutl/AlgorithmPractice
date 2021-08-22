package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Cheeze{
	int x;
	int y;
	public Cheeze(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class ДЎБо {
	public static boolean[][] visit;
	public static boolean flag;
	public static int answer = Integer.MAX_VALUE;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] cheezes = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				cheezes[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(cheezes,n,m));
	}

	private static String solution(int[][] cheezes, int n, int m) {
		StringBuilder sb = new StringBuilder();
		int day = 0;
		answer = Integer.MAX_VALUE;
		countingCheeze(cheezes);
		while(true) {
			
			visit = new boolean[n][m];
			flag = true;
			bfs(cheezes,0,0);
			if(flag)
				break;
			day++;
			countingCheeze(cheezes);
		}
		sb.append(day + "\n");
		sb.append(answer);
		return sb.toString();
	}

	private static void countingCheeze(int[][] cheezes) {
		int count = 0;
		for(int i=0;i<cheezes.length;++i) {
			for(int j=0;j<cheezes[i].length;++j) {
				if(cheezes[i][j] == 1)
					count++;
			}
		}
		if(count == 0) {
			return;
		}
		answer = Math.min(answer, count);
	}

	private static void bfs(int[][] cheezes, int x, int y) {
		Queue<Cheeze> que = new LinkedList<>();
		que.offer(new Cheeze(x, y));
		visit[y][x] = true;
		
		while(!que.isEmpty()) {
			Cheeze c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				if(0 <= nx && nx < cheezes[0].length  && 0 <= ny && ny < cheezes.length) {
					if(!visit[ny][nx] && cheezes[ny][nx] == 0) {
						visit[ny][nx] = true;
						que.offer(new Cheeze(nx, ny));
					}else if(!visit[ny][nx] && cheezes[ny][nx] == 1) {
						flag = false;
						visit[ny][nx] = true;
						cheezes[ny][nx] = 0;
					}
				}
			}
			
		}
		
	}

}
