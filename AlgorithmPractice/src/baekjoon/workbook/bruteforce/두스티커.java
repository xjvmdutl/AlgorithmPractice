package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두스티커 {
	private static int answer;
	private static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int h = Integer.parseInt(tokens.nextToken());
		int w = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, h, w, n));
	}

	private static int solution(int[][] arr, int h, int w, int n) {
		answer = 0;
		visit = new boolean[n];
		permutation(arr, n, 0, 0, 2, new int[2], h, w);
		return answer;
	}

	private static void permutation(int[][] arr, int n, int count, int index, int size, int[] choices, int h, int w) {
		if(size == count) {
			int h1 = arr[choices[0]][0];
			int w1 = arr[choices[0]][1];
			int h2 = arr[choices[1]][0];
			int w2 = arr[choices[1]][1];
			if(checkHW(h1, w1, h2, w2, h, w)) {
				int area = (h1* w1) + (h2* w2);
				answer = Math.max(area, answer);
			}else {
				for(int i=0;i<3;++i) {
					int[] rotaions = rotation(h1, w1, h2, w2, i);
					if(checkHW(rotaions[0], rotaions[1], rotaions[2], rotaions[3], h, w)) {
						int area = (h1* w1) + (h2* w2);
						answer = Math.max(area, answer);
						break;
					}
				}
			}
			return;
		}
		for(int i=index;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				choices[count] = i;
				permutation(arr, n, count+1, i, size, choices, h, w);
				visit[i] = false;
			}
		}
	}

	private static boolean checkHW(int h1, int w1, int h2, int w2, int h, int w) {
		if(checkWidth(h1, w1, h2, w2, h, w) || checkHeight(h1, w1, h2, w2, h, w)) {
			return true;
		}
		return false;
	}

	private static boolean checkWidth(int h1, int w1, int h2, int w2, int h, int w) {
		return w1 + w2 <= w && Math.max(h1, h2) <= h;
	}
	
	private static boolean checkHeight(int h1, int w1, int h2, int w2, int h, int w) {
		return h1 + h2 <= h && Math.max(w1, w2) <= w;
	}

	private static int[] rotation(int h1, int w1, int h2, int w2, int flag) {
		int[] result = new int[4];
		switch (flag) {
		case 0 : {
			result[0] = w1;
			result[1] = h1;
			result[2] = h2;
			result[3] = w2;
			break;
		}
		case 1 : {
			result[0] = h1;
			result[1] = w1;
			result[2] = w2;
			result[3] = h2;
			break;
		}
		case 2 : {
			result[0] = w1;
			result[1] = h1;
			result[2] = w2;
			result[3] = h2;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + flag);
		}
		return result;
	}

}
