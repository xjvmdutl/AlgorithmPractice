package baekjoon.workbook.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 끝나지않는파티 {

	private static final int MAX_VALUE = 1000000001;
	private static final int BLANK = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		int[][] question = new int[m][3];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			question[i][0] = Integer.parseInt(tokens.nextToken());
			question[i][1] = Integer.parseInt(tokens.nextToken());
			question[i][2] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map, n, m, question));
		
	}

	private static String solution(int[][] map, int n, int m, int[][] question) {
		init(map, n);
		floydWashal(map, n, m);
		return getResult(map, question);
	}

	private static void init(int[][] map, int n) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(isBlank(map[i][j])) {
					map[i][j] = MAX_VALUE;
				}
			}	
		}	
	}

	private static boolean isBlank(int num) {
		return num == BLANK;
	}

	private static void floydWashal(int[][] map, int n, int m) {
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}	
			}	
		}
		
	}

	private static String getResult(int[][] map, int[][] question) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<question.length;++i) {
			int a = question[i][0] - 1;
			int b = question[i][1] - 1;
			int c = question[i][2];
			if(map[a][b] <= c) {
				answer.append("Enjoy other party\n");
			}else {
				answer.append("Stay here\n");
			}
		}		
		return answer.toString();
	}

}
