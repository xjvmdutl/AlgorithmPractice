package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¿îµ¿ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int v = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[v][v];
		for(int i=0;i<e;++i) {
			tokens = new StringTokenizer(reader.readLine());	
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken());
			arr[a][b] = c;
		}
		System.out.println(solution(arr,v));
	}

	private static int solution(int[][] arr, int v) {
		final int INF = 4000001;
		int answer = INF;
		int[][] d = new int[v][v];
		for(int i=0;i<v;++i) {
			for(int j=0;j<v;++j) {
				if(arr[i][j] == 0 && i != j) {
					d[i][j] = INF;
				}else {
					d[i][j] = arr[i][j];
				}
			}
		}
		for(int k=0;k<v;++k) {
			for(int i=0;i<v;++i) {
				for(int j=0;j<v;++j) {
					if(d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		for(int i=0;i<v;++i) {
			for(int j=0;j<v;++j) {
				if(i == j)
					continue;
				if(d[i][j] != INF && d[j][i] != INF) {
					answer = Math.min(answer, d[i][j] + d[j][i]);
				}
			}
		}
		return answer == INF ? -1 : answer;
	}

}
