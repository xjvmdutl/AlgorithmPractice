package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Bung{
	int x;
	int y;
	public Bung(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class ¿¸¿Ô¿¸≈ı {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[m][n];
		for(int i=0;i<m;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map,m,n));
		
	}

	private static String solution(char[][] map, int m, int n) {
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[2];
		visit = new boolean[m][n];
		for(int i=0;i<m;++i) {
			for(int j=0;j<n;++j) {
				if(!visit[i][j]) {
					int number = bfs(map,j,i,map[i][j],m,n);
					if(map[i][j] == 'W')
						arr[0] += number*number;
					else
						arr[1] += number*number;
				}
			}
		}
		sb.append(arr[0] + " " + arr[1]);
		return sb.toString();
	}

	private static int bfs(char[][] map, int x, int y, char c, int m, int n) {
		Queue<Bung> que = new LinkedList<>();
		int size = 0;
		que.offer(new Bung(x, y));
		visit[y][x] = true;
		while(!que.isEmpty()){
			Bung b = que.poll();
			size++;
			for(int i=0;i<4;++i) {
				int nx = dx[i] + b.x;
				int ny = dy[i] + b.y;
				if(isRnage(nx,ny,m,n) && !visit[ny][nx] && map[ny][nx] == c) {
					visit[ny][nx] =true;
					que.offer(new Bung(nx, ny));
				}
			}
		}
		return size;
	}

	private static boolean isRnage(int nx, int ny, int m, int n) {
		return 0<=nx&&nx<n&&0<=ny&&ny<m;
	}

}
