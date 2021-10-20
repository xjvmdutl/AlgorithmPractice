package baekjoon.problems.shortermupgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 행렬제곱 {
	public static int[][] origin;
	public static void main(String[] args) throws IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		long b = Long.parseLong(tokens.nextToken());
		int[][] map = new int[n][n];
		origin = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken()) % 1000;
				origin[i][j] = map[i][j];
			}	
		}
		System.out.println(solution(map,n,b));
	}

	private static String solution(int[][] map, int n, long b) {
		
		int[][] result = pow(map, b, n);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				sb.append(result[i][j] + " ");
			}	
			sb.append("\n");
		}
		return sb.toString();
	}

	private static int[][] pow(int[][] map, long b, int n) {
		if(b == 1) {
			return map;
		}
		int[][] ret = pow(map, b/2, n);
		ret = multiply(ret, ret, n);
		// 만약 지수가 홀수라면 마지막에  A^1 (origin)을 곱해준다.
		if(b % 2 == 1) {
			ret = multiply(ret, origin, n);
		}
		return ret;
	}

	private static int[][] multiply(int[][] ret1, int[][] ret2,int n) {
		int[][] returns = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				for(int k=0;k<n;++k) {
					returns[i][j] += ret1[i][k] * ret2[k][j];
				}
				returns[i][j] %= 1000;
			}	
		}
		return returns;
	}

}
