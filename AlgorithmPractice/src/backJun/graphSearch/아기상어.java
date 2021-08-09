package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark {
	int x;
	int y;
	int distance;
	public Shark(int x,int y,int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}

public class 아기상어 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int weight;
	public static int answer;
	public static int eatCount;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		answer = 0;
		weight = 2;
		eatCount = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(arr[i][j] == 9) {
					int x = j;
					int y = i;
					arr[i][j] = 0;
					bfs(arr,j,i,n);
				}
			}
		}
		return answer;
	}

	private static void bfs(int[][] arr, int x, int y,int n) {
		Queue<Shark> que = new LinkedList<>();
		List<Shark> fishes = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		que.offer(new Shark(x, y, 0));
		visited[y][x] = true;
		while(!que.isEmpty()) {
			Shark s = que.poll();
			for(int i=0;i<4;++i) {
				int nx = s.x + dx[i];
				int ny = s.y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if(visited[ny][nx])
					continue;
				if(1 <= arr[ny][nx] && arr[ny][nx] < weight) {
					fishes.add(new Shark(nx, ny, s.distance+1));
					que.offer(new Shark(nx, ny, s.distance+1));
					visited[ny][nx] = true;
				}else if(arr[ny][nx] == weight || arr[ny][nx] == 0 ) {
					que.offer(new Shark(nx, ny, s.distance+1));
					visited[ny][nx] = true;
				}
			}
		}
		if(fishes.isEmpty())
			return;
		
		
		Collections.sort(fishes,(o1,o2)->{
			if(o1.distance == o2.distance) {
				if(o1.y == o2.y) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}
			
			return o1.distance - o2.distance;
		});
		Shark eatShark = fishes.get(0);
		answer += eatShark.distance;
		eatCount++;
		if(eatCount == weight) {
			eatCount = 0;
			weight++;
		}
		arr[eatShark.y][eatShark.x] = 0;
		bfs(arr,eatShark.x,eatShark.y,n);
	}

	
}
