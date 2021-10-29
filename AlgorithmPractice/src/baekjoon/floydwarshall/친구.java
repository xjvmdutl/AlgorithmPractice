package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ä£±¸ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[][] map = new char[n][n];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<n;++j) {
				map[i][j] = str.charAt(j);
			}	
		}
		System.out.println(solution(map,n));
		
	}

	private static int solution(char[][] map, int n) {
		int answer = 0;
		char[][] tmp = new char[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(map[i][j] == 'Y')
					tmp[i][j] = 'Y';
			}	
		}
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][k] == 'Y' && map[k][j] == 'Y') {
						tmp[i][j] = 'Y';
						tmp[j][i] = 'Y';
					}
				}	
			}	
		}
		for(int i=0;i<n;++i) {
			int count = 0;
			for(int j=0;j<n;++j) {
				if(i == j)
					continue;
				if(tmp[i][j] == 'Y')
					count++;
			}	
			answer = Math.max(answer, count);
		}
		return answer;
	}
}
