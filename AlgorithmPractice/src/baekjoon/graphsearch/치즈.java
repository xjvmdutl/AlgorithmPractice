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
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] cheeze = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				cheeze[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(cheeze,n,m));
	}

	private static String solution(int[][] cheeze, int n, int m) {
		StringBuilder sb = new StringBuilder();
		while(true) {
			visit = new boolean[n][m];
			boolean flag = true;
			for(int i=0;i<n;++i) {
				for(int j=0;j<m;++j) {
					if(cheeze[i][j] == 0 && !visit[i][j]) {
						bfs(cheeze,j,i);
						flag = false;
					}
				}
			}
			if(flag) {
				break;
			}
		}
		return sb.toString();
	}

	private static void bfs(int[][] cheeze, int x, int y) {
		Queue<Cheeze> que = new LinkedList<>();
		que.offer(new Cheeze(x, y));
		visit[y][x] = true;
		while(!que.isEmpty()) {
			
		}
	}

}
