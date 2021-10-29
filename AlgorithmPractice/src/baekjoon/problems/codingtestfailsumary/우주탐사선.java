package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class øÏ¡÷≈ΩªÁº± {
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n,k));
	}

	private static int solution(int[][] map, int N, int K) {
		answer = Integer.MAX_VALUE;
		for(int k=0;k<N;++k) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}	
			}
		}
		boolean[] visit = new boolean[N];
		visit[K] = true;
		dfs(map,1,K,0,N,visit);
		return answer;
	}

	private static void dfs(int[][] map, int count,int k, int value, int n, boolean[] visit) {
		if(count == n) {
			answer = Math.min(answer, value);
			return;
		}
		for(int i=0;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(map, count+1, i, value + map[k][i], n, visit);
				visit[i] = false;
			}
		}
	}
}
