package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식 {
	private static boolean[] visit;
	private static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][2];
		for(int i=0; i<n; ++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int sourTaste = Integer.parseInt(tokens.nextToken());
			int bitter = Integer.parseInt(tokens.nextToken());
			map[i][0] = sourTaste;
			map[i][1] = bitter;
		}
		System.out.println(solution(map, n));
	}

	private static int solution(int[][] map, int n) {
		answer = Integer.MAX_VALUE;
		for(int i=1; i<=n; ++i) {
			visit = new boolean[n];
			permutation(map, n, 0, 0, i, new int[i][2]);
		}
		return answer;
	}

	private static void permutation(int[][] map, int n, int index, int count, int size, int[][] arr) {
		if(count == size) {
			answer = Math.min(answer, calculate(arr));
			return;
		}
		
		for(int i=index;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				arr[count][0] = map[i][0];
				arr[count][1] = map[i][1];
				permutation(map, n, i, count + 1, size, arr);
				visit[i] = false;
			}
		}
	}

	private static int calculate(int[][] arr) {
		int sourTaste = 1;
		int bitterSum = 0;
		for(int i=0;i<arr.length;++i) {
			sourTaste *= arr[i][0];
			bitterSum += arr[i][1];
		}
		return Math.abs(sourTaste - bitterSum);
	}


}
