package baekjoon.workbook.today;

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
		System.out.println(-2 %2);
		boolean[][] visit = new boolean[n][m];
		permulate(visit, 0, n, m);
		return answer;
	}
	private static void permulate(boolean[][] visit, int count, int n, int m) {
		if(count == n*m) {
			answer++;
			return;
		}
		int y = count / m;
		int x = count % m;
		boolean flag = false;
		if(y > 0 && x > 0) {
			if(visit[y-1][x-1] && visit[y][x-1] && visit[y-1][x]) {
				flag = true;
				permulate(visit, count+1, n, m);
			}
		}
		if(!flag) {
			permulate(visit, count+1, n, m);
			visit[y][x] = true;
			permulate(visit, count+1, n, m);
			visit[y][x] = false;
		}
	}
	
}
