package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원이동하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][3];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			map[i][0] = Integer.parseInt(tokens.nextToken());
			map[i][1] = Integer.parseInt(tokens.nextToken());
			map[i][2] = Integer.parseInt(tokens.nextToken());
		}
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(map, n, a, b));
	}

	private static String solution(int[][] map, int n, int a, int b) {
		
		return null;
	}

}
