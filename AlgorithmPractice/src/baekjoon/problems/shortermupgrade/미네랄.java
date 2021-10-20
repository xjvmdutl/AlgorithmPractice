package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Mineral{
	int x;
	int y;
	public Mineral(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 미네랄 {
	public static List<Mineral> cluster;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
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
		tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			 arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map,arr,n,r,c));
	}

	private static String solution(char[][] map, int[] arr, int n, int r, int c) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;++i) {
			int R = r - arr[i];
			if(i%2 == 0) {
				//왼 -> 오
				for(int j=0;j<c;++j) {
					if(map[R][j] == 'x') {
						map[R][j] = '.';
						break;
					}
				}
			}else {
				//오 -> 왼
				for(int j=c-1;j>=0;--j) {
					if(map[R][j] == 'x') {
						map[R][j] = '.';
						break;
					}
				}
			}
			findCluster(map,r,c);
			if(cluster.size() != 0) 
				dropMineral(map,r,c);
			cluster.clear();
		}
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				sb.append(map[i][j]);
			}	
			sb.append("\n");
		}
		return sb.toString();
	}

	private static void dropMineral(char[][] map, int r, int c) {
		int cnt = 0;
		
		// 현재 떨어질 클러스터를 모두 지운다. 
		for(Mineral m : cluster) {
			map[m.y][m.x] = '.';
		}
		OUTER: for(int i = 1 ; i < r ; ++i) {
			for(Mineral m : cluster) {
				if(m.y + i >= r || map[m.y + i][m.x] == 'x') {
					break OUTER;
				}
			}
			cnt = i;
		}
		// 계산된 칸 만큼 이동시킨 클러스터를 새로 그린다. 
		for(Mineral m : cluster) {
			map[m.y + cnt][m.x] = 'x';
		}
		
	}

	private static void findCluster(char[][] map, int r, int c) {
		cluster = new ArrayList<Mineral>();
		Queue<Mineral> que = new LinkedList<>();
		boolean[][] visit = new boolean[r][c];
		for(int i=0;i<c;++i) {
			if(map[r-1][i] == 'x') {
				que.offer(new Mineral(i, r-1));
			}
		}
		while(!que.isEmpty()) {
			Mineral m = que.poll();
			for(int i=0;i<4;++i) {
				int nx = dx[i] + m.x;
				int ny = dy[i] + m.y;
				if(isRange(nx,ny,r,c) && !visit[ny][nx] && map[ny][nx] == 'x') {
					visit[ny][nx] = true;
					que.offer(new Mineral(nx, ny));
				}
			}
		}
		for(int i = 0 ; i < r ; ++i) {
			for(int j = 0 ; j < c ; ++j) {
				if(map[i][j] == 'x' && !visit[i][j]) {
					cluster.add(new Mineral(j, i));
				}
			}
		}
		
	}

	private static boolean isRange(int nx, int ny, int r, int c) {
		return 0 <= nx && nx < c && 0 <= ny && ny < r;
	}
	

}
