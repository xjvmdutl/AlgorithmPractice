package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5 {
	public static int[][] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
		sum = new int[n+1][n+1];

		init(map, n);
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			System.out.println(solution(map, n, x1, y1, x2, y2));
		}
	}

	private static void init(int[][] map, int n) {
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=n;++j) {
				sum[i][j] = sum[i][j-1] + map[i-1][j-1];
			}	
		}
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=n;++j) {
				sum[i][j] += sum[i-1][j];
			}	
		}
	}

	private static int solution(int[][] map, int n, int x1, int y1, int x2, int y2) {
		int answer= sum[x2][y2];
		answer -= sum[x2][y1-1];
		answer -= sum[x1-1][y2];
		answer += sum[x1-1][y1-1];
		return answer;
	}

}
