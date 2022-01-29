package baekjoon.workbook.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2 {
	public static boolean[] visit;
	public static int answer;
	private static int solution(int[][] map, int n) {
		answer = Integer.MAX_VALUE;
		visit = new boolean[n];
		permulate(map,0,0,n,0);
		return answer;
	}
	private static void permulate(int[][] map, int now, int count, int n,int money) {
		if(count == n) {
			if(now == 0) {
				answer = Math.min(answer, money);
				return;
			}
		}
		for(int i=0;i<n;++i) {
			if(!visit[i] && map[now][i] != 0) {
				visit[i] = true;
				permulate(map, i, count+1, n, money + map[now][i]);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n));
	}



}
