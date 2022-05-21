package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ºí·¢Àè {
	private static boolean[] visit;
	private static int min;
	private static int solution(int[] map, int n, int m) {
		visit = new boolean[n];
		min = Integer.MAX_VALUE;
		permutation(map, n, m, 0, 0, 3, 0);
		
		return m - min;
	}
	
	private static void permutation(int[] map, int n, int m, int index, int count, int size, int sum) {
		if(count == size) {
			if(m - sum >= 0 && m - sum < min ) {
				min = m - sum;
			}
			return;
		}
		for(int i=index;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				permutation(map, n, m, i, count+1, size, sum + map[i]);
				visit[i] = false;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[] map = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			map[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map, n, m));
	}


}
