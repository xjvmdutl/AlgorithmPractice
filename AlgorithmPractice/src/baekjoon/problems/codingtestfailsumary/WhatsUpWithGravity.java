package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Bovidian implements Comparable<Bovidian>{
	int x;
	int y;
	int count;
	public Bovidian(int x,int y,int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	@Override
	public int compareTo(Bovidian o) {
		return this.count - o.count;
	}
}
public class WhatsUpWithGravity {
	public static int[][][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<m;++j) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(char[][] map, int n, int m) {
		Bovidian start = null;
		Bovidian end = null;
		visit = new int[n][m][2];
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] == 'C') {
					start = new Bovidian(j, i, 0);
				}
				if (map[i][j] == 'D') {
					end = new Bovidian(j, i, 0);
				}
				for(int k=0;k<2;++k)
					visit[i][j][k] = Integer.MAX_VALUE;
			}	
		}
		
		return bfs(map,n,m,start,end);
	}

	private static int bfs(char[][] map, int n, int m, Bovidian start, Bovidian end) {
		Queue<Bovidian> pq = new PriorityQueue<>();
		pq.offer(start);
		visit[start.y][start.x][0] = 0; 
		OUTER:while(!pq.isEmpty()) {
			Bovidian b = pq.poll();
			if(end.y == b.y && end.x == b.x) {
				return b.count;
			}
			int ny = b.y;
			int dir = b.count % 2;
			if(dir == 0) {
				while(true) {
					if (ny >= n - 1)
						continue OUTER;
					if(map[ny + 1][b.x] == '#') {
						break;
					}
					if(map[ny + 1][b.x] == 'D') {
						return b.count;
					}
					ny++;
				}
			}else {
				while(true) {
					if (ny <= 0)
						continue OUTER;
					if(map[ny - 1][b.x] == '#') {
						break;
					}
					if(map[ny - 1][b.x] == 'D') {
						return b.count;
					}
					ny--;
				}
			}
			if(visit[ny][b.x][dir] > b.count + 1) {
				pq.offer(new Bovidian(b.x, ny, b.count));
				visit[ny][b.x][dir] = b.count;
			}
			// 중력 전환
			if (visit[ny][b.x][(dir+1)%2] > b.count + 1) {
				pq.offer(new Bovidian(b.x, ny, b.count +1));
				visit[ny][b.x][(dir+1)%2] = b.count + 1;
			}
			// left
			int nx = b.x - 1;
			if (nx > -1 && (map[ny][nx] == '.' || map[ny][nx] == 'D') && visit[ny][nx][dir] > b.count + 1) {
				pq.offer(new Bovidian(nx, ny, b.count));
				visit[ny][nx][dir] = b.count;
			}
			// right
			nx = b.x + 1;
			if (nx < m && (map[ny][nx] == '.' || map[ny][nx] == 'D') && visit[ny][nx][dir] > b.count + 1) {
				pq.offer(new Bovidian(nx, ny, b.count));
				visit[ny][nx][dir] = b.count;
			}
		}
		return -1;
	}

}
