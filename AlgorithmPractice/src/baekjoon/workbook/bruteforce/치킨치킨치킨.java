package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ġŲġŲġŲ {
	private static boolean[] visit;
	private static int answer;
	private static int solution(int[][] map, int n, int m) {
		answer = 0;
		visit = new boolean[m];
		permutation(map, new int[3], 0, 3, 0, n, m);
		return answer;
	}
	
	private static void permutation(int[][] map, int[] arr, int count, int size, int index, int n, int m) {
		if(count == size) {
			int sum = 0;
			for(int i=0;i<n;++i) {
				int max = 0;
				for(int j=0;j<3;++j) {
					int idx = arr[j];
					max = Math.max(max, map[i][idx]);
				}
				sum += max;
			}
			answer = Math.max(answer, sum);
			return;
		}
		for(int i = index; i < m; ++i) {
			if(!visit[i]) {
				visit[i] = true;
				arr[count] = i;
				permutation(map, arr, count+1, size, i, n, m);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][m];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<m;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(map, n, m));
	}

}
