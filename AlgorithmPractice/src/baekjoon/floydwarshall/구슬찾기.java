package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			map[start-1][end-1] = 1;
			map[end-1][start-1] = -1;
		}
		System.out.println(solution(map,n));
	}

	private static int solution(int[][] map, int n) {
		int answer = 0;
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][k] != 0 && map[i][k] == map[k][j] ) {
						map[i][j] = map[i][k];
					}
				}	
			}
		}
		int mid = (n + 1) / 2;
		for(int i=0;i<n;++i) {
			int min_count = 0;
			int max_count = 0;
			for(int j=0;j<n;++j) {
				if (map[i][j] == -1)
					min_count++;
				else if (map[i][j] == 1)
					max_count++;
			}
			
			if(mid <= min_count) {
				answer++;
			}else if(mid <= max_count){
				answer++;
			}
		}
		return answer;
	}

}
