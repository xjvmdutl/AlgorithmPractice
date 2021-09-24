package baekjoon.kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Àü·Â³­ {
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int m = Integer.parseInt(tokens.nextToken());
			int n = Integer.parseInt(tokens.nextToken());
			if(m == 0 && n == 0)
				break;
			int[][] arr = new int[n][3];
			for(int i=0;i<n;++i) {
				tokens = new StringTokenizer(reader.readLine());
				arr[i][0] = Integer.parseInt(tokens.nextToken());
				arr[i][1] = Integer.parseInt(tokens.nextToken());
				arr[i][2] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(arr,m,n));
		}
	}

	private static int solution(int[][] arr, int m, int n) {
		int answer = 0;
		parents = new int[m];
		for(int i=0;i<m;++i) {
			parents[i] = i;
		}
		Arrays.sort(arr,(o1,o2)->o1[2]-o2[2]);
		for(int i=0;i<arr.length;++i) {
			int parent = findNode(arr[i][0]);
			int child = findNode(arr[i][1]);
			if(parent == child) {
				answer+=arr[i][2];
				continue;
			}
			parents[child] = parent;
		}
		return answer;
	}

	private static int findNode(int node) {
		if(node == parents[node])
			return node;
		return parents[node] = findNode(parents[node]);
	}

}
