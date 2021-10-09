package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Person{
	int x;
	int y;
	public Person(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class 인구이동 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int l = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n,l,r));
	}

	private static int solution(int[][] map, int n, int l, int r) {
		int answer = 0;
		while(true) {
			int cnt = 0;
			visit = new boolean[n][n];
			List<List<Person>> list = new ArrayList<>();
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(!visit[i][j]) {
						cnt++;
						list.add(new ArrayList<>());
						int num = bfs(map,n,l,r,j,i,list);
						List<Person> per = list.get(list.size()-1);
						for(Person p : per) {
							map[p.y][p.x] = num;
						}
					}
				}
			}
			
			if(n * n == cnt)
				break;
			answer++;
		}
		return answer;
	}

	private static int bfs(int[][] map, int n, int l, int r, int x, int y, List<List<Person>> list) {
		Queue<Person> que = new LinkedList<>();
		que.offer(new Person(x, y));
		visit[y][x] = true;
		int sum = 0;
		while(!que.isEmpty()) {
			Person p = que.poll();
			sum += map[p.y][p.x];
			list.get(list.size()-1).add(p);
			for(int i=0;i<4;++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < n) {
					if(!visit[ny][nx]) {
						int diff = Math.abs(map[p.y][p.x] - map[ny][nx]);
						if(diff >= l && diff <= r) {
							visit[ny][nx] = true;
							que.offer(new Person(nx, ny));
						}
					}
				}
			}
		}
		return sum/list.get(list.size()-1).size();
	}

}
