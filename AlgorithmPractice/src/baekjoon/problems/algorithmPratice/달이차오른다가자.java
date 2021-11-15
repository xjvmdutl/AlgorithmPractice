package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Moon implements Comparable<Moon>{
	int x;
	int y;
	int dis;
	int key;
	public Moon(int x,int y,int dis,int key){
		this.dis = dis;
		this.x = x;
		this.y = y;
		this.key = key;
	}
	@Override
	public int compareTo(Moon o) {
		return this.dis - o.dis;
	}
}
public class ´ÞÀÌÂ÷¿À¸¥´Ù°¡ÀÚ {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static Moon start = null;
	public static boolean[][][] visit;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map,n,m));
	}

	private static int solution(char[][] map, int n, int m) {
		answer = -1;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] == '0')
					start = new Moon(j, i, 0,0);
			}
		}
		visit = new boolean[n][m][64];
		bfs(map,n,m);
		return answer;
	}

	private static void bfs(char[][] map, int n, int m) {
		Queue<Moon> que = new PriorityQueue<>();
		visit[start.y][start.x][0] = true;
		que.offer(start);
		while(!que.isEmpty()) {
			Moon moon = que.poll();
			int distance = moon.dis;
			int key = moon.key;
			if(map[moon.y][moon.x] == '1') {
				answer = moon.dis;
				return;
			}
			for(int i=0;i<4;++i) {
				int nx = moon.x + dx[i];
				int ny = moon.y + dy[i];
				if(!isRange(nx,ny,n,m) || map[ny][nx] == '#' || visit[ny][nx][key]) {
					continue;
				}
				if(0 <= map[ny][nx] - 'a' && map[ny][nx] - 'a' < 6) {
					//¿­¼è
					int tmpKey = (1 << map[ny][nx] - 'a') | key;//ÇØ´ç ¿­¼è¸¦ ´õÇØÁÜ
					if(!visit[ny][nx][tmpKey]) {
						visit[ny][nx][tmpKey] = true;
						visit[ny][nx][key] = true;
						que.offer(new Moon(nx, ny, distance+1, tmpKey));
					}
				}else if(0 <= map[ny][nx] - 'A' && map[ny][nx] - 'A' < 6) {
					//¹®
					int tmpDoor = (1 << map[ny][nx] - 'a') & key;//ÇØ´ç ¿­¼è¸¦ ´õÇØÁÜ
					if(tmpDoor > 0) {
						visit[ny][nx][key] = true;
						que.offer(new Moon(nx, ny, distance+1, key));
					}
				}else {
					//ºó°÷
					visit[ny][nx][key] = true;
					que.offer(new Moon(nx, ny, distance+1, key));
				}
				
			}
		}
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

}
