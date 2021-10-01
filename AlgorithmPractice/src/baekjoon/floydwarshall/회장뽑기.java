package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class »∏¿ÂªÃ±‚ {
	public static int[][] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr= new int[n][n];
		while(true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			if(a == -2 && b == -2) {
				break;
			}
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		System.out.println(solution(arr,n));
	}
	private static String solution(int[][] arr, int n) {
		d = new int[n][n];
		final int INF = 51;
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(arr[i][j] == 0 && i != j)
					d[i][j] = INF;
				else
					d[i][j] = arr[i][j];
			}
		}
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int score = INF;
		for(int i=0;i<n;++i) {
			int max = Arrays.stream(d[i]).max().getAsInt();
			score = Math.min(score, max);
		}
		
		int count = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;++i) {
			int max = Arrays.stream(d[i]).max().getAsInt();
			if(max == score) {
				count++;
				list.add(i+1);
			}
		}
		sb.append(score + " " + count + "\n");
		for(int i=0;i<list.size();++i) {
			sb.append(list.get(i) + " ");
		}
		return sb.toString();
	}

}
