package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작 {
	public static boolean finish = false;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int h = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[h][n];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken()) - 1;
			int b = Integer.parseInt(tokens.nextToken()) - 1;
			map[a][b] = 1;
			map[a][b+1] = 2;
		}
		System.out.println(solution(map,n,m,h));
	}
	private static int solution(int[][] map, int n, int m, int h) {
		int answer = 0;
		for(int i=0;i<4;++i) {
			answer = i;
			dfs(map,n,m,h,0,0,i);
			if(finish) {
				break;
			}
		}
		return finish ? answer : -1;
	}
	private static void dfs(int[][] map, int n, int m, int h, int index,int count, int length) {
		if(finish)
			return;
		if(count == length) {
			if(check(map,n,m,h)) {
				finish = true;
			}
			return;
		}
		for(int i=index;i<h;++i) {
			for(int j=0;j<n-1;++j) {
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1] = 2;
					dfs(map, n, m, h, i, count+1, length);
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
	}
	private static boolean check(int[][] map, int n, int m, int h) {
		for(int i=0;i<n;++i) {
			int number = i;
			for(int j=0;j<h;++j) {
				if(map[j][number] == 1) {
					number++;
				}else if(map[j][number] == 2) {
					number--;
				}
			}
			if(i != number)
				return false;
		}
		return true;
	}

	
}
