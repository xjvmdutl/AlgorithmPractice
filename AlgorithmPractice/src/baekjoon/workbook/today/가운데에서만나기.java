package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 가운데에서만나기 {

	private static final int INF = (200 * 199) + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			int time = Integer.parseInt(tokens.nextToken());
			map[start][end] = time;
		}
		int k = Integer.parseInt(reader.readLine());
		int[] arr= new int[k];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<k;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(map, arr, n, m, k));
	}

	private static String solution(int[][] map, int[] arr, int n, int m, int k) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		
		for(int i=0;i<n;++i) { 
			for(int j=0;j<n;++j) { 
				if(i != j && map[i][j] == 0) {
					map[i][j] = INF;
				}
			}
		}
		 
		for(int l=0;l<n;++l) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] > map[i][l] + map[l][j]) {
						map[i][j] = map[i][l] + map[l][j];
					}
				}	
			}
		}
		
		int[] datas = new int[n];
		int min = INF;
		for(int i=0;i<n;++i) {
			int max = 0;
			for(int j=0;j<arr.length;++j) {
				int now = arr[j] - 1;
				max = Math.max(map[now][i] + map[i][now], max);
			}
			min = Math.min(max, min);
			datas[i] = max;
		}
		for(int i=0;i<n;++i)
			if(datas[i] == min)
				sb.append((i+1) + " ");
		
		
		return sb.toString();
	}
		
}
