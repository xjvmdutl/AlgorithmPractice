package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Sand{
	int x;
	int y;
	public Sand(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 모래성 {
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static Queue<Sand> que;
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int h = Integer.parseInt(tokens.nextToken());
		int w = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[h][w];
		for(int i=0;i<h;++i) {
			String str = reader.readLine();
			for(int j=0;j<w;++j) {
				map[i][j] = str.charAt(j) == '.' ? -1 : Character.getNumericValue(str.charAt(j));
			}
		}
		System.out.println(solution(map, h, w));
	}

	private static int solution(int[][] map, int h, int w) {
		int time = -1;
		que = new LinkedList<>();
		visit= new boolean[h][w];
		init(map, h, w);
		int len = que.size();
		int nowCount = 0;
		while(!que.isEmpty()) {
			Sand sand = que.poll(); //비어있는 곳을 뽑아
			nowCount++;
			
			List<Sand> list = setEmptySand(map, sand.x, sand.y, h, w);
			if(!list.isEmpty()) {
				for(Sand s : list) {
					que.offer(s);
				}
			}
			
			if(nowCount == len) {
				time++;
				nowCount = 0;
				len = que.size();
			}
		}
		return time;
	}

	private static List<Sand> setEmptySand(int[][] map, int x, int y, int h, int w) {
		List<Sand> list = new ArrayList<Sand>();
		for(int i=0;i<8;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx, ny, h, w)) {
				if(map[ny][nx] > 0) {
					map[ny][nx]--;
				}
				if(map[ny][nx] == 0 && !visit[ny][nx]) {
					map[ny][nx] = -1;
					visit[ny][nx] = true;
					list.add(new Sand(nx, ny));
				}
			}
		}
		return list;
	}

	private static void init(int[][] map, int h, int w) {
		for(int i=0;i<h;++i) {
			for(int j=0;j<w;++j) {
				if(map[i][j] == -1) {
					que.offer(new Sand(j, i));
					visit[i][j] = true;
				}
			}	
		}
	}

	private static boolean isRange(int nx, int ny, int h, int w) {
		return 0 <= nx && nx < w && 0 <= ny && ny < h;
	}
}
