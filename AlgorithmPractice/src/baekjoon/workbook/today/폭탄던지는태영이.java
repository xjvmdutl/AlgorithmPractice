package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ÆøÅº´øÁö´ÂÅÂ¿µÀÌ {

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
		System.out.println(solution(map , n, m));
	}

	private static String solution(int[][] map, int n, int m) {
		StringBuilder sb = new StringBuilder();
		long[][] ret = new long[n][n];
		long[][] sum = new long[n+2][n+2];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				checkBomb(map, ret, sum, i, j, n, m);
				sb.append(ret[i][j] + " ");
			}	
			sb.append("\n");
		}
		return sb.toString();
	}

	private static void checkBomb(int[][] map, long[][] ret, long[][] sum, int y, int x, int n, int m) {
		int r = m / 2;
		if(y + r >= n || x + r >= n)
			return;
		ret[y + r][x + r] = Math.abs(map[y][x]) - Math.abs(gridSum(sum, y - r + 1, x - r + 1, y + r + 1, x + r + 1) - sum[y + r][x + r]);
		sum[y + r + 1][x + r + 1] = ret[y + r][x + r] + sum[y + r + 1][x + r] +sum[y + r][x + r + 1] - sum[y + r][x + r];
		sum[y + r + 1][x + r + 2] += sum[y + r + 1][x + r + 1];
		sum[y + r + 2][x + r + 1] += sum[y + r + 1][x + r + 1];
	}

	private static long gridSum(long[][] sum, int y1, int x1, int y2, int x2) {
		long ret = sum[y2][x2];
		if(y1 > 0)	ret -= sum[y1-1][x2];
		if(x1 > 0)	ret -= sum[y2][x1-1];
		if(y1 > 0 && x1 > 0)	ret += sum[y1-1][x1-1];
		return ret;
	}

}
