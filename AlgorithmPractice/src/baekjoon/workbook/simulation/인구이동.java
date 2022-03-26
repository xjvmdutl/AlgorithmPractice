package baekjoon.workbook.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {
	static class Person{
		int x;
		int y;
		public Person(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static boolean isStart;
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static List<Integer> sums;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int l = Integer.parseInt(tokens.nextToken());
		int k =  Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map, l, k, n));
	}

	private static int solution(int[][] map, int l, int k, int n) {
		int answer = 0;
		while(true) {
			isStart = false;
			visit = new boolean[n][n];
			List<List<Person>> list = new ArrayList<>();
			sums = new ArrayList<Integer>();
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(!visit[i][j]) {
						List<Person> returns = bfs(map,j,i,l,k, n);
						if(returns.size() > 1) {
							list.add(returns);
						}
					}
				}	
			}
			if(!isStart) {
				break;
			}
			answer++;
			for(int i=0;i<list.size();++i) {
				int now = sums.get(i) / list.get(i).size();
				for(Person person: list.get(i)) {
					map[person.y][person.x] = now; 
				}
			}
		}
		return answer;
	}

	private static List<Person> bfs(int[][] map, int x, int y, int l, int k, int n) {
		Queue<Person> que = new LinkedList<>();
		que.offer(new Person(x, y));
		List<Person> list = new ArrayList<>();
		list.add(new Person(x, y));
		int sum = map[y][x];
		visit[y][x] = true;
		while(!que.isEmpty()) {
			Person p = que.poll();
			for(int i=0;i<4;++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(isRange(nx, ny, n) 
					&& !visit[ny][nx] 
					&& l <= Math.abs(map[p.y][p.x] - map[ny][nx])
					&& Math.abs(map[p.y][p.x] - map[ny][nx]) <= k ) {
					visit[ny][nx] = true;
					isStart = true;
					list.add(new Person(nx, ny));
					sum += map[ny][nx];
					que.offer(new Person(nx,ny));
				}
			}
		}
		if(list.size() > 1) {
			sums.add(sum);
		}
		return list;
	}

	private static boolean isRange(int nx, int ny, int n) {
		return 0 <= nx && nx < n && 0 <= ny && ny < n;
	}


}
