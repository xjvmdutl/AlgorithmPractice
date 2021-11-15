package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Cluster{
	int x;
	int y;
	public Cluster(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class ¹Ì³×¶ö {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean[][] visit;
	public static List<Cluster> clusteres;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[r][c];
		for(int i=0;i<r;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		int n = Integer.parseInt(reader.readLine());
		tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(map,r,c,arr,n));
	}

	private static String solution(char[][] map, int r, int c, int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;++i) {
			clusteres = new ArrayList<>();
			int row = r - arr[i];
			if(i%2 == 0) {
				for(int j=0;j<c;++j) {
					if(map[row][j] == 'x') {
						map[row][j] = '.';
						break;
					}
				}
			}else {
				for(int j=c-1;j>=0;--j) {
					if(map[row][j] == 'x') {
						map[row][j] = '.';
						break;
					}
				}
			}
			find(map,r,c);
			if(clusteres.size() > 0) {
				dropCluster(map,r,c);
			}
		}
		print(map,r,c,sb);
		return sb.toString();
	}

	private static void dropCluster(char[][] map, int r, int c) {
		for(Cluster cluster : clusteres) {
			map[cluster.y][cluster.x] = '.';
		}
		int dropPoint = 0;
		OUTER:for(int i=1;i<r;++i) {
			for(Cluster cluster : clusteres) {
				int ny = cluster.y + i;
				if(r <= ny || map[ny][cluster.x] == 'x') {
					break OUTER;
				}
			}
			dropPoint = i;
		}
		for(Cluster cluster : clusteres) {
			int ny = cluster.y + dropPoint;
			map[ny][cluster.x] = 'x';
		}
	}

	private static void find(char[][] map, int r, int c) {
		Queue<Cluster> que= new LinkedList<>();
		visit = new boolean[r][c];
		for(int i=0;i<c;++i) {
			if(map[r-1][i] == 'x') {
				que.offer(new Cluster(i, r-1));
				visit[r-1][i] = true;
			}
		}
		while(!que.isEmpty()) {
			Cluster cluster = que.poll();
			for(int i=0;i<4;++i) {
				int nx = cluster.x + dx[i];
				int ny = cluster.y + dy[i];
				if(isRange(nx,ny,r,c) && !visit[ny][nx] && map[ny][nx] == 'x') {
					que.offer(new Cluster(nx, ny));
					visit[ny][nx] = true;
				}
			}
		}
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(!visit[i][j] && map[i][j] == 'x') {
					clusteres.add(new Cluster(j, i));
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny && ny < r;
	}

	private static void print(char[][] map, int r, int c, StringBuilder sb) {
		for(int i=0;i<r;++i) {
			for(int j =0;j<c;++j) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}

}
