package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][m];
		for(int i=0;i<n;++i) {
			map[i] = reader.readLine().toCharArray();
		}
		System.out.println(solution(map, n, m));
	}

	private static int solution(char[][] map, int n, int m) {
		int answer = Integer.MAX_VALUE;
		for(int i=0;i<n-7;++i) {
			for(int j=0;j<m-7;++j) {
				answer = Math.min(Count(map, n, m, i, j), answer);
			}	
		}
		return answer;
	}

	private static int Count(char[][] map, int n, int m, int y, int x) {
		int count = 0;
		char now = map[y][x];
		for(int i=y;i<y+8;++i) {
			for(int j=x;j<x+8;++j) {
				if(map[i][j] != now) {
					count++;
				}
				now = now == 'B' ? 'W' : 'B'; 
			}	
			now = now == 'B' ? 'W' : 'B';
		}
		
		
		return Math.min(count, 64 - count);
	}

}
