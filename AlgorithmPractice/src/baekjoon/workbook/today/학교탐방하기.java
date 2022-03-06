package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 학교탐방하기 {
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[m+1][3];
		for(int i=0;i<m+1;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			arr[i][0] = start;
			arr[i][1] = end;
			arr[i][2] = c == 1 ? 0 : 1;
		}
		System.out.println(solution( arr, n, m));
	}

	private static int solution(int[][] arr, int n, int m) {
		parents = new int[n+1];
		for(int i=0;i<n+1;++i) {
			parents[i] = i;
		}
		
		int max = MaxMST(arr, n, m);
		for(int i=0;i<n+1;++i) {
			parents[i] = i;
		}
		int min = MinMST(arr, n, m);
		return (int) (Math.pow(max, 2) - Math.pow(min, 2));
	}

	private static int MinMST(int[][] arr, int n, int m) {
		int answer = 0;
		Arrays.sort(arr, (o1,o2)->{
			return o1[2] - o2[2];
		});
		for(int i=0;i<m;++i) {
			int n1 = find(arr[i][0]);
			int n2 = find(arr[i][1]);
			if(n1 == n2) {
				continue;
			}
			answer+= arr[i][2];
			parents[n1] = n2;
		}
		return answer;
	}

	private static int MaxMST(int[][] arr, int n, int m) {
		int answer = 0;
		Arrays.sort(arr, (o1,o2)->{
			return o2[2] - o1[2];
		});
		for(int i=0;i<m;++i) {
			int n1 = find(arr[i][0]);
			int n2 = find(arr[i][1]);
			if(n1 == n2) {
				continue;
			}
			answer+= arr[i][2];
			parents[n1] = n2;
		}
		return answer;
	}

	private static int find(int node) {
		if(node == parents[node])
			return node;
		return parents[node] = find(parents[node]);
	}

}
