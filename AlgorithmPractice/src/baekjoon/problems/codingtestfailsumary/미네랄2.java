package baekjoon.problems.codingtestfailsumary;

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
public class ¹Ì³×¶ö2 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static List<Cluster> clusters;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[r][c];
		for(int i=0;i<r;++i) {
			String str = reader.readLine();
			for(int j=0;j<c;++j) {
				map[i][j] = str.charAt(j);
			}
		}
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map,r,c,arr,n));
	}

	private static String solution(char[][] map, int r, int c, int[] arr, int n) {
		for(int i=0;i<n;++i) {
			int now = r - arr[i];
			if(i % 2 == 0) {
				for(int j=0;j<c;++j) {
					if(map[now][j] == 'x') {
						map[now][j] = '.';
						break;
					}
				}
			}else {
				for(int j=c-1;j>=0;--j) {
					if(map[now][j] == 'x') {
						map[now][j] = '.';
						break;
					}
				}
			}
			clusters = new ArrayList<>();
			findCluster(map,r,c);
			if(clusters.size() > 0) {
				dropCluster(map,r,c);
			}
		}
		return print(map,r,c);
	}

	private static void dropCluster(char[][] map, int r, int c) {
		int drop = 0;
		for(Cluster cluster : clusters) {
			map[cluster.y][cluster.x] = '.';
		}
		OUTER:for(int i=1;i<=r;++i) {
			for(Cluster cluster : clusters) {
				if(cluster.y + i >= r || map[cluster.y + i][cluster.x] == 'x') {
					break OUTER;
				}
			}
			drop = i;
		}
		
		for(Cluster cluster : clusters) {
			map[cluster.y+drop][cluster.x] = 'x';
		}
		
	}

	private static void findCluster(char[][] map, int r, int c) {
		Queue<Cluster> que = new LinkedList<>();
		boolean[][] visit = new boolean[r][c];
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
					visit[ny][nx] = true;
					que.offer(new Cluster(nx, ny));
				}
			}
		}
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				if(!visit[i][j] && map[i][j] == 'x') {
					clusters.add(new Cluster(j, i));
				}
			}	
		}
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny && ny < r;
	}

	private static String print(char[][] map, int r, int c) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				sb.append(map[i][j]);
			}	
			sb.append("\n");
		}
		return sb.toString();
	}

}
