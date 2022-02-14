package baekjoon.workbook.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ³Û¸ð³Û¸ð {
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,m));
	}

	private static int solution(int n, int m) {
		answer = 0;
		boolean[][] map = new boolean[n+1][m+1];
		permulate(map, 0, n, m);
		return answer;
	}

	private static void permulate(boolean[][] map, int count, int n, int m) {
		if(count == n*m) {
			answer++;
			return;
		}
		int y = (count / m) + 1;
		int x = (count % m) + 1;
		if(map[y-1][x] && map[y][x-1] && map[y-1][x-1]) {
			permulate(map, count+1, n, m);
		}else {
			permulate(map, count+1, n, m);
			map[y][x] = true;
			permulate(map, count+1, n, m);
			map[y][x] = false;
		}
	}
	
}
