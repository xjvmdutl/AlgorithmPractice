package baekjoon.kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획 {
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[m][3];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			arr[i][2] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,m));
	}

	private static int solution(int[][] arr, int n, int m) {
		int answer = 0;
		parents = new int[n];
		for(int i=0;i<n;++i) {
			parents[i] = i;
		}
		Arrays.sort(arr,(o1,o2)->o1[2]-o2[2]);
		int maxValue = 0;
		for(int i=0;i<m;++i) {
			int parent = findNode(arr[i][0]-1);
			int child = findNode(arr[i][1]-1);
			if(parent == child)
				continue;
			maxValue = Math.max(maxValue, arr[i][2]);
			answer += arr[i][2];
			parents[child] = parent;
		}
		return answer - maxValue;
	}

	private static int findNode(int node) {
		if(parents[node] == node)
			return node;
		return parents[node] = findNode(parents[node]);
	}

}
