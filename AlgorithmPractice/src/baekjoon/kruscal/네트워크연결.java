package baekjoon.kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 네트워크연결 {
	public static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		int[][] arr = new int[m][3];
		for(int i=0;i<m;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			arr[i][2] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,m));
	}

	private static int solution(int[][] arr, int n,int m) {
		int answer = 0;
		parents = new int[n];
		for(int i=0;i<n;++i) {
			parents[i] = i;
		}
		Arrays.sort(arr,(o1,o2)->{
			return o1[2] - o2[2];
		});
		for(int i=0;i<m;++i) {
			int parent = findNode(arr[i][0]-1);
			int child = findNode(arr[i][1]-1);
			if(parent == child)
				continue;
			answer += arr[i][2];
			parents[child] = parent;
		}
		
		
		return answer;
	}

	private static int findNode(int node) {
		if(node == parents[node])
			return node;
		return findNode(parents[node]);
	}

}
