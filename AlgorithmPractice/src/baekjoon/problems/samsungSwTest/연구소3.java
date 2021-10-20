package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Virus01{
	int x;
	int y;
	int time;
	public Virus01(int x,int y,int time) {
		this.x = x;
		this.y = y;
		this.time=time;
	}
}
public class ¿¬±¸¼Ò3 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer;
	public static Virus01[] active;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		List<Virus01> list = new ArrayList<>();
		int originEmptySpace = 0;
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if(map[i][j] == 2)
					list.add(new Virus01(j, i, 0));
				else if(map[i][j] == 0)
					originEmptySpace++;
			}	
		}
		System.out.println(solution(map,n,m,list,originEmptySpace));
	}

	private static int solution(int[][] map, int n, int m, List<Virus01> list, int originEmptySpace) {
		if(originEmptySpace == 0)
			return 0;
		active = new Virus01[m];
		answer = Integer.MAX_VALUE;
		dfs(map,n,0,0,m,list,originEmptySpace);
		if(answer == Integer.MAX_VALUE)
			return -1;
		return answer;
	}

	private static void dfs(int[][] map, int n,int index ,int count, int m, List<Virus01> list, int originEmptySpace) {
		if(count == m) {
			int num = spreadVirus(map,n,originEmptySpace,m);
			if(num != -1) {
				answer = Math.min(answer, num);
			}
			return;
		}
		for (int i = index; i < list.size(); i++) {
            active[count] = list.get(i);
	        dfs(map, n, i+1, count+1, m, list,originEmptySpace);
	    }
	}

	private static int spreadVirus(int[][] map, int n, int originEmptySpace,int m) {
		Queue<Virus01> que = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		 for (int i = 0; i < m; i++) {
            Virus01 virus = active[i];
            visit[virus.y][virus.x] = true;
            que.offer(virus);
        }
		int resultMinTime = -1;
		while(!que.isEmpty()) {
			Virus01 v = que.poll();
			for(int i=0;i<4;++i) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < n) {
					if(visit[ny][nx] || map[ny][nx] == 1) {
						continue;
					}
					if (map[ny][nx] == 0) {
						originEmptySpace--;
	                }
					if (originEmptySpace == 0) {
	                    resultMinTime = v.time + 1;
	                    return resultMinTime;
	                }
					visit[ny][nx] = true;
					que.offer(new Virus01(nx, ny, v.time+1));
				}
			}
		}
		return resultMinTime;
	}
}
