package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class °æ»ç·Î {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int l = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(map,n,l));
	}

	private static int solution(int[][] map, int n, int l) {
		int answer = 0;
		for(int i=0;i<n;++i) {
			if(go(map,i,0,true,n,l)) {
				answer++;
			}
			if(go(map,0,i,false,n,l)) {
				answer++;
			}
		}
		
		return answer;
	}

	private static boolean go(int[][] map, int x, int y,boolean k, int n, int l) {
		int[] arr = new int[n];
		boolean[] visit = new boolean[n];
		if(k) {
			for(int i=0;i<n;++i) {
				arr[i] = map[x][i];
			}
		}else {
			for(int i=0;i<n;++i) {
				arr[i] = map[i][y];
			}
		}
		for(int i=0;i<n-1;++i) {
			if(Math.abs(arr[i] - arr[i+1]) > 1)
				return false;
			if(arr[i] == arr[i+1])
				continue;
			if(arr[i] - 1 == arr[i+1]) {
				int index = i+1;
				for(int j=index;j<index+l;++j) {
					if(j >= n || arr[j] != arr[i+1] || visit[j]) {
						return false;
					}
					
					visit[j] = true;
				}
			}else {
				int index = i;
				for(int j=index;j>index-l;--j) {
					if(j < 0 || arr[j] != arr[i] || visit[j]) {
						return false;
					}
					visit[j] = true;
				}
			}
		}
		return true;
	}
}
