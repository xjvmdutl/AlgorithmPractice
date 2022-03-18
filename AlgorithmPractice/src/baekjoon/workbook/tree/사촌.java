package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ªÁ√Ã {
	public static int[] parents;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int k = Integer.parseInt(tokens.nextToken());
			if(n == 0 && k == 0) {
				break;
			}
			arr = new int[n + 1];
			parents = new int[n + 1];
			arr[0] = -1;
			parents[0] = -1;
			int target = 0;
			int count = -1;
			tokens = new StringTokenizer(reader.readLine());
			for(int i=1;i<=n;++i) {
				arr[i] = Integer.parseInt(tokens.nextToken());
				if(arr[i] == k) {
					target = i;
				}
				if(Math.abs(arr[i] - arr[i-1]) != 1) {
					count++;
				}
				parents[i] = count;
			}
			System.out.println(solution(n, k, target));
		}
	}
	private static int solution(int n, int k, int target) {
		int count = 0;
		for(int i=1;i<=n;++i) {
			if(parents[i] != parents[target] 
					&& parents[parents[i]] == parents[parents[target]]) {
				count++; 
			}
		}
		return count;
	}

}
