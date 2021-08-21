package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Knight{
	int x;
	int y;
	public Knight(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 나이트의이동 {
	
	public static boolean[][] visited;
	public static int[][] lengths;
	public static Queue<Knight> que;
	public static int answer = 0;
	public static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	public static int[] dy = {2,1,-1,-2,-2,-1,1,2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		for(int i=0;i<n;++i) {
			int l = Integer.parseInt(reader.readLine());
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(reader.readLine());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			System.out.println(solution(l,x1,y1,x2,y2));
			
		}
	}

	private static int solution(int l, int x1, int y1, int x2, int y2) {
		answer = 0;
		visited = new boolean[l][l];
		lengths = new int[l][l];
		que = new LinkedList<>();
		visited[y1][x1] = true;
		lengths[y1][x1] = 1;
		que.offer(new Knight(x1, y1));
		bfs(x2,y2,l);
		
		return answer;
	}

	private static void bfs(int x2, int y2,int l) {
		while(!que.isEmpty()) {
			Knight knight = que.poll();
			if(knight.x == x2 && knight.y == y2)
				break;
			for(int i=0;i<8;++i) {
				int x = knight.x + dx[i];
				int y = knight.y + dy[i];
				if(0 <= x && x < l && 0 <= y && y < l) {
					if(!visited[y][x]) {
						que.offer(new Knight(x, y));
						visited[y][x] = true;
						lengths[y][x] = lengths[knight.y][knight.x] + 1;
					}
				}
			}
		}
		answer = lengths[y2][x2] - 1;
	}

}
