package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
class Cow{
	int x;
	int y;
	public Cow(int x,int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		return this.x + this.y;
	}
	@Override
	public boolean equals(Object obj) {
		Cow c = (Cow)obj;
		return c.x == this.x && c.y == this.y;
	}
	
}
public class 소가길을건너간이유6 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static List<Set<Cow>> road = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		
		for(int i=0;i<r;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int startR = Integer.parseInt(tokens.nextToken()) - 1;
			int startC = Integer.parseInt(tokens.nextToken()) - 1;
			int endR = Integer.parseInt(tokens.nextToken()) - 1;
			int endC = Integer.parseInt(tokens.nextToken()) - 1;
			Set<Cow> set = new HashSet<>();
			set.add(new Cow(startR, startC));
			set.add(new Cow(endR, endC));
			road.add(set);
		}
		Cow[] arr = new Cow[k];
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(tokens.nextToken()) - 1;
			int x = Integer.parseInt(tokens.nextToken()) - 1;
			arr[i] = new Cow(x,y);
		}
		System.out.println(solution(arr,n,k,r));
	}

	private static int solution(Cow[] arr, int n, int k, int r) {
		int answer = 0;
		for(int i=0;i<arr.length;++i) {
			for(int j=i+1;j<arr.length;++j) {
				Cow c1 = arr[i];
				Cow c2 = arr[j];
				if(!bfs(n,c1,c2)) {
					answer++;
				}
			}
		}
		return answer;
	}

	private static boolean bfs(int n, Cow start, Cow end) {
		Queue<Cow> que = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		que.offer(new Cow(start.x, start.y));
		visit[start.y][start.x]= true;
		while(!que.isEmpty()) {
			Cow c = que.poll();
			if(c.y == end.y && c.x == end.x) {
				return true;
			}
			OUTER:for(int i=0;i<4;++i) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				if(isRange(nx,ny,n) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					for(Set<Cow> set: road) {
						if(set.contains(new Cow(nx,ny)) && set.contains(c) ) {
							continue OUTER;
						}
					}
					que.offer(new Cow(nx,ny));
					
				}
			}
		}
		return false;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}

}
