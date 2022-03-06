package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class VirusSearch{
	int x;
	int y;
	public VirusSearch(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class ¿¬±¸¼Ò {
	public static boolean[][] visit;
	public static List<VirusSearch> vList;
	public static int answer;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens= new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(int[][] map, int n, int m) {
		answer = 0;
		visit = new boolean[n][m];
		vList = new ArrayList<>();
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] == 2) {
					vList.add(new VirusSearch(j, i));
				}
			}	
		}
		permulate(map, 0, 3, n, m);
		return answer;
	}

	private static void permulate(int[][] map, int count, int length, int n, int m) {
		if(count == length) {
			int[][] spreadMap = bfs(map, n, m);
			int cnt = counting(spreadMap, n, m);
			answer = Math.max(answer, cnt);
			return;
		}
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					permulate(map, count+1, length, n, m);
					map[i][j] = 0;
				}
			}	
		}
	}

	private static int counting(int[][] map, int n, int m) {
		int count = 0;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j] == 0) {
					count++;
				}
			}	
		}
		return count;
	}

	private static int[][] bfs(int[][] map, int n, int m) {
		int[][] tmp = new int[n][m];
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				tmp[i][j] = map[i][j];
			}	
		}
		Queue<VirusSearch> que = new LinkedList<>();
		for(int i=0;i<vList.size();++i) {
			VirusSearch v = vList.get(i);
			visit[v.y][v.x] = true;
			que.offer(new VirusSearch(v.x, v.y));
		}
		visit= new boolean[n][m];
		while(!que.isEmpty()) {
			VirusSearch v = que.poll();
			for(int i=0;i<4;++i) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if(isRange(nx, ny, n, m) && !visit[ny][nx] && tmp[ny][nx] == 0) {
					visit[ny][nx] = true;
					tmp[ny][nx] = 2;
					que.offer(new VirusSearch(nx, ny));
				}
			}
		}
		return tmp;
	}

	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}

}
