package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Laser implements Comparable<Laser>{
	int x;
	int y;
	int dir;
	int count;
	public Laser(int x,int y,int count,int dir){
		this.count = count;
		this.x = x;
		this.dir = dir;
		this.y = y;
	}
	@Override
	public int compareTo(Laser o) {
		return this.count - o.count;
	}
}
public class 레이저통신 {
	public static int[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int w = Integer.parseInt(tokens.nextToken());
		int h = Integer.parseInt(tokens.nextToken());
		char[][] arr = new char[h][w];
		Laser startLaser = null;
		Laser endLaser = null;
		for(int i=0;i<h;++i) {
			String str = reader.readLine();
			arr[i] = str.toCharArray();
			for(int j=0;j<arr[i].length;++j) {
				if(arr[i][j] == 'C' && startLaser == null) {
					startLaser = new Laser(j, i, -1, 0);
				}else if(arr[i][j] == 'C') {
					endLaser = new Laser(j, i, -1, 0);
				}
			}
		}
		System.out.println(solution(arr,w,h,startLaser,endLaser));
	}

	private static int solution(char[][] arr, int w, int h, Laser startLaser, Laser endLaser) {
		answer = 0;
		visit = new int[h][w];
		for(int i=0;i<h;++i) {
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		bfs(arr,w,h,startLaser,endLaser);
		return answer;
	}

	private static void bfs(char[][] arr, int w, int h, Laser startLaser, Laser endLaser) {
		Queue<Laser> pq = new PriorityQueue<>();
		pq.offer(startLaser);
		visit[startLaser.y][startLaser.x] = 0;
		while(!pq.isEmpty()) {
			Laser l = pq.poll();
			int x = l.x; //현재 좌표
            int y = l.y;
            int dir = l.dir;
            int count = l.count;
            
			if(x == endLaser.x
					&& y == endLaser.y) {
				 answer = Math.min(count, answer);
			}
			for(int i=0;i<4;++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
                int nd = i;
                if (nx < 0 || ny < 0 || nx >= w || ny >= h || arr[ny][nx] == '*') {
                    continue;
                }
                int temp = count;
                if (dir != nd && dir != -1) {
                    temp++;
                }

                if (visit[ny][nx] < temp) {
                    continue;
                }

                visit[ny][nx] = temp;
                pq.add(new Laser(nx, ny, nd, temp));
			}
		}
	}

}
