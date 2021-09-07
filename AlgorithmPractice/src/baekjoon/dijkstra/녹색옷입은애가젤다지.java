package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Lupi implements Comparable<Lupi>{
	int x;
	int y;
	int money;
	public Lupi(int x,int y,int money) {
		this.x = x;
		this.y = y;
		this.money = money;
	}
	@Override
	public int compareTo(Lupi o) {
		return this.money - o.money;
	}
}
public class ≥Ïªˆø ¿‘¿∫æ÷∞°¡©¥Ÿ¡ˆ {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int[][] visit;	
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		int count = 0;
		while((n = Integer.parseInt(reader.readLine())) != 0) {
			count++;
			int[][] arr = new int[n][n];
			for(int i=0;i<n;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				for(int j=0;j<n;++j) {
					arr[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			System.out.println("Problem " + count + ": "+ solution(n,arr));
		}
	}

	private static int solution(int n, int[][] arr) {
		answer = Integer.MAX_VALUE;
		visit = new int[n][n];
		for(int i=0;i<n;++i) {
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		visit[0][0] = arr[0][0];
		Dijkstra(arr,n);
		return answer;
	}

	private static void Dijkstra(int[][] arr, int n) {
		Queue<Lupi> que = new PriorityQueue<>();
		que.offer(new Lupi(0, 0, arr[0][0]));
		while(!que.isEmpty()) {
			Lupi l = que.poll();
			if(l.x == n-1 && l.y == n-1) {
				answer = Math.min(l.money, answer);
				continue;
			}
			for(int i=0;i<4;++i) {
				int x = l.x + dx[i];
				int y = l.y + dy[i];
				if(0 <= x && x < n && 0 <= y && y < n) {
					if(visit[y][x] > visit[l.y][l.x] + arr[y][x]) {
						visit[y][x] = visit[l.y][l.x] + arr[y][x];
						que.offer(new Lupi(x, y, visit[y][x]));
					}
				}
			}
		}
	}

}
