package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사냥꾼 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		int l = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[m];
		for(int i=0;i<m;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		int[][] map = new int[n][2];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			map[i][0] = Integer.parseInt(tokens.nextToken());
			map[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map, arr, m, n, l));
	}

	private static int solution(int[][] map, int[] arr, int m, int n, int l) {
		int answer = 0;
		Arrays.sort(arr);
		for(int i=0;i<n;++i) {
			answer += binarySearch(arr, map[i][0], map[i][1], m, n, l);	
		}
		return answer;
	}

	private static int binarySearch(int[] arr, int x, int y, int m, int n, int l) {
		int start = 0;
		int end = m;
		while(start <= end) {
			int mid = (start + end) / 2;
			// 범위 초과
			if (mid >= m) {
				return 0;
			}
			int distance = Math.abs(x - arr[mid]) + y;
			if(l < distance && x < arr[mid]) {
				end = mid - 1;
			}else if(l < distance && x >= arr[mid]) {
				start = mid + 1;
			}else if(distance <= l){
				return 1;
			}
		}
		return 0;
	}

}
