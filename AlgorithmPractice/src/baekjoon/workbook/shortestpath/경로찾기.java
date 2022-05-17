package baekjoon.workbook.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		boolean[][] map = new boolean[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken()) == 0 ? false : true;
			}
		}
		System.out.println(solution(map, n));
	}

	private static String solution(boolean[][] map, int n) {
		floydWassal(map, n);
		return getResult(map, n);
	}

	private static void floydWassal(boolean[][] map, int n) {
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][k] && map[k][j]) {
						map[i][j] = true;
					}
				}
			}	
		}
	}

	private static String getResult(boolean[][] map, int n) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				answer.append(map[i][j] == true ? 1 : 0);
				answer.append(" ");
			}
			answer.append("\n");
		}
		
		return answer.toString();
	}

}
