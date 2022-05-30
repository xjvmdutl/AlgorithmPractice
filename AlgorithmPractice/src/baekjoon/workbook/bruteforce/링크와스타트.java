package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 링크와스타트 {
	private static boolean[] visit;
	private static int answer;
	private static int solution(int[][] map, int n) {
		answer = Integer.MAX_VALUE;
		for(int i=1;i<n;++i) {
			visit = new boolean[n];
			permutation(map, n, 0, 0, i);
		}
		return answer;
	}

	private static void permutation(int[][] map, int n, int index, int count, int size) {
		if(count == size) {
			answer = Math.min(answer, calculate(map, n));
			return;
		}
		for(int i=index;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				permutation(map, n, i, count + 1, size);
				visit[i] = false;
			}
		}
	}
	

	private static int calculate(int[][] map, int n) {
		int stark = 0;
		int link = 0;
		for(int i=0; i<n-1;++i) {
			for(int j=i+1;j<n;++j) {
				if(visit[i] && visit[j]) {
					stark += (map[i][j] + map[j][i]);
				}else if(!visit[i] && !visit[j]) {
					link += (map[i][j] + map[j][i]);
				}
			}
		}
		
		return Math.abs(stark - link);
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
		System.out.println(solution(map, n));
	}

}
