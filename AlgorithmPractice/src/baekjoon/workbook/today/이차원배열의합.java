package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원배열의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j =0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		int[][] sum = Sum(map, n, m);
		int k = Integer.parseInt(reader.readLine());
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(tokens.nextToken()) - 1;
			int y1 = Integer.parseInt(tokens.nextToken()) - 1;
			int x2 = Integer.parseInt(tokens.nextToken()) - 1;
			int y2 = Integer.parseInt(tokens.nextToken()) - 1;
			System.out.println(solution(sum, x1, y1, x2, y2));
		}
	}

	private static int[][] Sum(int[][] map, int n, int m) {
		int[][] returns = new int[n][m];
		for(int i=0;i<n;++i) {
			returns[i][0] = map[i][0];
			for(int j=1;j<m;++j) {
				returns[i][j] = returns[i][j-1] + map[i][j]; 
			}
		}
		return returns;
	}

	private static int solution(int[][] sum, int x1, int y1, int x2, int y2) {
		int answer = 0;
		for(int i=x1; i<=x2;++i) {
			int num1 = y1 > 0 ? sum[i][y1-1] : 0;
			int num2 = sum[i][y2];
			answer += num2 - num1;
		}
		return answer;
	}

}
