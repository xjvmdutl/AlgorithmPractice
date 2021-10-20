package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Map01{
	int x;
	int y;
	int dir;
	public Map01(int x,int y,int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
public class 주사위굴리기 {
	public static int[] dice = {0,0,0,0,0,0};
	public static StringBuilder sb;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken());
		int y = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		int[] arr = new int[k];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<k;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map,arr,n,m,k,x,y));
	}

	private static String solution(int[][] map, int[] arr, int n, int m, int k, int x, int y) {
		sb = new StringBuilder();
		bfs(map,arr,n,m,k,x,y);
		return sb.toString();
	}

	private static void bfs(int[][] map, int[] arr, int n, int m, int k, int x, int y) {
		Map01 maps = new Map01(x, y,5);
		for(int i=0;i<arr.length;++i) {
			int dir = arr[i] - 1;
			int diceDir = maps.dir;
			int nx = dx[dir] + maps.x;
			int ny = dy[dir] + maps.y;
			if(0 <= ny && ny < n && 0 <= nx && nx < m) {
				/*
				 * 		0
				 * 1	2	4
				 * 		3
				 * 		5
				 * */
				int newDiceDir = 0;
				int change = 0;
				if(dir == 0) {
					if(diceDir == 0 || diceDir == 2 || diceDir == 3 || diceDir == 5) {
						change = 4;
						newDiceDir = 1;
					}else if(diceDir == 1){
						change = 2;
						newDiceDir = 5;
					}else if(diceDir == 4) {
						change = 5;
						newDiceDir = 2;
					}
				}else if(dir == 1) {
					if(diceDir == 0 || diceDir == 2 || diceDir == 3 || diceDir == 5) {
						change = 1;
						newDiceDir = 4;
					}else if(diceDir == 1){
						change = 5;
						newDiceDir = 2;
					}else if(diceDir == 4) {
						change = 2;
						newDiceDir = 5;
					}
					
				}else if(dir == 2) {
					if(diceDir == 0 || diceDir == 2 || diceDir == 3 || diceDir == 5) {
						change = 4;
						newDiceDir = 1;
					}else if(diceDir == 1){
						change = 2;
						newDiceDir = 5;
					}else if(diceDir == 4) {
						change = 5;
						newDiceDir = 2;
					}
				}else if(dir == 3) {
					if(diceDir == 0 || diceDir == 2 || diceDir == 3 || diceDir == 5) {
						change = 4;
						newDiceDir = 1;
					}else if(diceDir == 1){
						change = 2;
						newDiceDir = 5;
					}else if(diceDir == 4) {
						change = 5;
						newDiceDir = 2;
					}
				}
				if(map[ny][nx] == 0) {
					map[ny][nx] = dice[change];
				}else {
					dice[change] = map[ny][nx];
					map[ny][nx] = 0;
				}
				maps = new Map01(nx, ny, newDiceDir);	
			}
		}
	}

}
