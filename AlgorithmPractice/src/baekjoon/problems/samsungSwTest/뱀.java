package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Snake{
	int x;
	int y;
	public Snake(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class ¹ì {
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int[] changeLeft = {3,2,0,1};
	public static int[] changeRight = {2,3,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int k = Integer.parseInt(reader.readLine());
		int[][] apple = new int[k][2];
		for(int i=0;i<k;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			apple[i][0] = Integer.parseInt(tokens.nextToken()) - 1;
			apple[i][1] = Integer.parseInt(tokens.nextToken()) - 1;
		}
		int l = Integer.parseInt(reader.readLine());
		String[][] times = new String[l][2];
		for(int i=0;i<l;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			times[i][0] = tokens.nextToken();
			times[i][1] = tokens.nextToken();
		}
		System.out.println(solution(apple,times,n,k,l));
	}
	
	private static int solution(int[][] apple, String[][] times, int n, int k, int l) {
		int answer = 0;
		
		int[][] map = new int[n][n];
		for(int i=0;i<apple.length;++i) {
			int x = apple[i][1];
			int y = apple[i][0];
			map[y][x] = 1;
		}
		answer = start(map,times,n);
		
		return answer;
	}

	private static int start(int[][] map, String[][] times, int n) {
		int time = 0;
		List<Snake> snake = new ArrayList<>();
		snake.add(new Snake(0, 0));
		int dir = 0;
		int idx = 0;
		while(true) {
			time++;
			
			Snake head = snake.get(snake.size()-1);
			int nx = head.x + dx[dir];
			int ny = head.y + dy[dir];
			if(nx < 0 || nx >= n || ny < 0 || ny >= n)
				break;
			
			Snake newHead = new Snake(nx, ny);
			for(Snake s : snake) {
				if(s.x == newHead.x && s.y == newHead.y) {
					return time;
				}
			}
			snake.add(newHead);
			if(map[ny][nx] == 1) {
				map[ny][nx] = 0;
			}else if(map[ny][nx] == 0) {
				snake.remove(0);
			}
			if(idx < times.length) {
				int now = Integer.parseInt(times[idx][0]);
				if(now == time) {
					if(times[idx][1].equals("L")) {
						dir = changeLeft[dir];
					}else {
						dir = changeRight[dir];
					}
					idx++;
				}
			}
		}
		return time;
	}

}
