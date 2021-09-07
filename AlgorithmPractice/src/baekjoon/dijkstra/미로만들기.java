package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Room implements Comparable<Room>{
	int x;
	int y;
	int breakCount;
	public Room(int x,int y,int breakCount) {
		this.x = x;
		this.y = y;
		this.breakCount = breakCount;
	}
	@Override
	public int compareTo(Room o) {
		return this.breakCount - o.breakCount;
	}
}
public class 미로만들기 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int[][] dis;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<n;++j) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		 answer = 0;
		dis = new int[n][n];
		for(int i=0;i<n;++i) {
			Arrays.fill(dis[i], Integer.MAX_VALUE);
		}
		Dijkstra(arr,n);
		return answer;
	}

	private static void Dijkstra(int[][] arr, int n) {
		Queue<Room> que = new PriorityQueue<>();
		que.offer(new Room(0, 0, 0));
		dis[0][0] = 0;
		while(!que.isEmpty()) {
			Room r = que.poll();
			if(r.x == n-1 && r.y == n-1) {
				answer = r.breakCount;
				break;
			}
			for(int i=0;i<4;++i) {
				int x = r.x + dx[i];
				int y = r.y + dy[i];
				if(0 <= x && x < n && 0 <= y && y < n) {
					int cnt = arr[y][x] == 0 ? 1 : 0; 
					if(dis[y][x] > dis[r.y][r.x] + cnt) {
						dis[y][x] = dis[r.y][r.x] + cnt;
						que.offer(new Room(x, y, dis[y][x]));
					}
				}
			}
		}
	}

}
